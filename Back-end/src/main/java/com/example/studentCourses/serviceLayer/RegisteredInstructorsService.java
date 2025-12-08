package com.example.studentCourses.serviceLayer;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.studentCourses.Entity.RegisteredInstructorsEntity;
import com.example.studentCourses.dtos.InstructorLoginRequest;
import com.example.studentCourses.dtos.InstructorResponse;
import com.example.studentCourses.dtos.LoginResponse;
import com.example.studentCourses.exceptions.AuthenticationFailedException;
import com.example.studentCourses.exceptions.ResourceNotFoundException;
import com.example.studentCourses.repository.RegisteredInstructorsRespository;
import com.example.studentCourses.security.JwtUtil;
@Service
public class RegisteredInstructorsService {

    @Autowired
    private RegisteredInstructorsRespository registeredInstructorsRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;
    
    public InstructorResponse getInstructor(Long id) {
    	RegisteredInstructorsEntity inst = registeredInstructorsRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Instructor not found with id: " + id));
    	return convertToResponse(inst);
    }
    

    // REGISTER INSTRUCTOR
    public InstructorResponse registerInstructor(RegisteredInstructorsEntity instructor) {

        instructor.setPassword(passwordEncoder.encode(instructor.getPassword()));
        instructor.setCreatedAt(LocalDateTime.now());
        instructor.setUpdatedAt(LocalDateTime.now());

        RegisteredInstructorsEntity saved = registeredInstructorsRepository.save(instructor);

        return convertToResponse(saved);
    }

    // LOGIN
    public LoginResponse loginInstructor(InstructorLoginRequest req) {

        RegisteredInstructorsEntity stored =
                registeredInstructorsRepository.findByEmail(req.getEmail());

        if (stored == null) {
            throw new ResourceNotFoundException("Instructor not found with email: " + req.getEmail());
        }

        if (!passwordEncoder.matches(req.getPassword(), stored.getPassword())) {
            throw new AuthenticationFailedException("Incorrect password");
        }

        String token = jwtUtil.generateToken(
                stored.getId(),
                stored.getFirstName(),
                stored.getLastName(),
                stored.getEmail(),
                stored.getCreatedAt(),
                stored.getUpdatedAt(),
                stored.getBio(),
                "INSTRUCTOR"
        );

        return new LoginResponse(token);
    }

    // ENTITY → DTO
    private InstructorResponse convertToResponse(RegisteredInstructorsEntity instructor) {

        InstructorResponse resp = new InstructorResponse();
        resp.setId(instructor.getId());
        resp.setFirstName(instructor.getFirstName());
        resp.setLastName(instructor.getLastName());
        resp.setEmail(instructor.getEmail());
        resp.setBio(instructor.getBio());
        resp.setCreatedAt(instructor.getCreatedAt());
        resp.setUpdatedAt(instructor.getUpdatedAt());
        return resp;
    }
}
