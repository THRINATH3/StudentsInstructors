package com.example.studentCourses.serviceLayer;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.studentCourses.Entity.CoursesEntity;
import com.example.studentCourses.dtos.CourseDetailsDTO;
import com.example.studentCourses.dtos.CourseResponseDTO;
import com.example.studentCourses.dtos.StudentCourseDTO;
import com.example.studentCourses.exceptions.ResourceNotFoundException;
import com.example.studentCourses.repository.CoursesRepository;

@Service
public class CoursesService {

    @Autowired
    private CoursesRepository courseRepository;

    public List<CourseResponseDTO> getCoursesList() {
        return courseRepository.findAll().stream().map(course ->
            new CourseResponseDTO(
                course.getcId(),
                course.getcTitle(),
                course.getcDescription(),
                course.getcCategory(),
                course.getcDuration(),
                course.getInstructor() != null
                    ? course.getInstructor().getFirstName() + " " + course.getInstructor().getLastName()
                    : null,
                course.getInstructor() != null
                    ? course.getInstructor().getEmail()
                    : null
            )
        ).toList();
    }

    public CoursesEntity registerCourse(CoursesEntity course) {
        course.setcCreatedAt(LocalDateTime.now());
        return courseRepository.save(course);
    }

    public CourseDetailsDTO getCourseDetails(Long id) {

        CoursesEntity course = courseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found"));

        List<StudentCourseDTO> registered = course.getRegisteredStudents().stream()
                .map(r -> new StudentCourseDTO(
                        r.getStudent().getSId(),
                        r.getStudent().getSFirstName(),
                        r.getStudent().getSLastName(),
                        r.getStudent().getSEmail(),
                        r.getEnrolledAt()
                )).toList();

        List<StudentCourseDTO> completed = course.getCompletedStudents().stream()
                .map(c -> new StudentCourseDTO(
                        c.getStudent().getSId(),
                        c.getStudent().getSFirstName(),
                        c.getStudent().getSLastName(),
                        c.getStudent().getSEmail(),
                        c.getCompletedAt()
                )).toList();

        return new CourseDetailsDTO(
                course.getcId(),
                course.getcTitle(),
                course.getcDescription(),
                course.getcCategory(),
                course.getcDuration(),
                course.getInstructor().getFirstName() + " " + course.getInstructor().getLastName(),
                course.getInstructor().getEmail(),
                registered,
                completed
        );
    }

	public Optional<CoursesEntity> getCourse(Long id) {
		return courseRepository.findById(id);
	}
}
