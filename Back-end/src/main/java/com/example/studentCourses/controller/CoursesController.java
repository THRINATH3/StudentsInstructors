package com.example.studentCourses.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.studentCourses.Entity.CoursesEntity;
import com.example.studentCourses.Entity.RegisteredInstructorsEntity;
import com.example.studentCourses.Entity.StudentRegisteredCoursesEntity;
import com.example.studentCourses.dtos.CourseResponseDTO;
import com.example.studentCourses.dtos.InstructorResponse;
import com.example.studentCourses.security.JwtUtil;
import com.example.studentCourses.serviceLayer.CoursesService;
import com.example.studentCourses.serviceLayer.RegisteredInstructorsService;
import com.example.studentCourses.serviceLayer.StudentRegisteredService;

@RestController
@RequestMapping("/courses")
public class CoursesController {
	
	@Autowired
	private CoursesService coursesService;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private RegisteredInstructorsService registeredInstructorsService;
	
	@Autowired
	private StudentRegisteredService enrollService;
	
	@GetMapping("/getAllCourses")
	public ResponseEntity<Object> getAllCourses() {
	    List<CourseResponseDTO> list = coursesService.getCoursesList();
	    return ResponseEntity.ok(list);
	}

	
	@PostMapping("/postCourse")
	public ResponseEntity<Object> postCourse(@RequestBody CoursesEntity course,@RequestHeader("Authorization") String authHeader){
		if(authHeader == null || !authHeader.startsWith("Bearer ")) {
			return ResponseEntity.status(401).body("Missing Authorization Header");
		}
		String token = authHeader.substring(7);
		if(!jwtUtil.validateToken(token)) {
			return ResponseEntity.status(401).body("Invalid Token");
		}
		
		Long Id = jwtUtil.getId(token);
		RegisteredInstructorsEntity inst = registeredInstructorsService.getInstructor(Id);
		
		course.setInstructor(inst);
		
		
		CoursesEntity post = coursesService.registerCourse(course);
		
		return ResponseEntity.ok(post);
		
	}
	
	@PostMapping("/enroll/{CourseID}")
	public ResponseEntity<Object> enrollStudent(@PathVariable Long CourseID,@RequestHeader("Authorization") String authHeader){
		if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return ResponseEntity.status(401).body("Missing Authorization header");
        }
        String token = authHeader.substring(7);

        if (!jwtUtil.validateToken(token)) {
            return ResponseEntity.status(401).body("Invalid token");
        }
        
        Long studentId = jwtUtil.getId(token);
        
        StudentRegisteredCoursesEntity enrolled = enrollService.enrollStudent(studentId, CourseID);
        return ResponseEntity.ok(enrolled);
	}
	
	@GetMapping("/getCourse/{id}")
	public ResponseEntity<Object> getIdCourse(@PathVariable Long id) {
        Optional<CoursesEntity> course = coursesService.getCourse(id);

        if (course == null) {
            return ResponseEntity.status(404).body("Course not found with id: " + id);
        }

        return ResponseEntity.ok(course);
	}
	
	@GetMapping("/{courseId}/students")
	public ResponseEntity<Object> getRegisteredStudents(
	        @PathVariable Long courseId,
	        @RequestHeader("Authorization") String authHeader) {

	    if (authHeader == null || !authHeader.startsWith("Bearer ")) {
	        return ResponseEntity.status(401).body("Missing Authorization Header");
	    }

	    String token = authHeader.substring(7);
	    if (!jwtUtil.validateToken(token)) {
	        return ResponseEntity.status(401).body("Invalid Token");
	    }

	    // OPTIONAL: role check (Instructor/Admin)
	    String role = jwtUtil.getRole(token);
	    if (!role.equals("INSTRUCTOR")) {
	        return ResponseEntity.status(403).body("Access Denied");
	    }

	    return ResponseEntity.ok(
	            enrollService.getStudentsByCourse(courseId)
	    );
	}

}
