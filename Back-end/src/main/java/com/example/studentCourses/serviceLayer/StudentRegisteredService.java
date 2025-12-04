package com.example.studentCourses.serviceLayer;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.studentCourses.Entity.CoursesEntity;
import com.example.studentCourses.Entity.RegisteredStudentsEntity;
import com.example.studentCourses.Entity.StudentRegisteredCoursesEntity;
import com.example.studentCourses.exceptions.ResourceNotFoundException;
import com.example.studentCourses.repository.CoursesRepository;
import com.example.studentCourses.repository.RegisteredStudentsRepository;
import com.example.studentCourses.repository.StudentRegisteredRepository;

@Service
public class StudentRegisteredService {

	@Autowired
	private RegisteredStudentsRepository registeredStudentsRepository;
	
	@Autowired
	private StudentRegisteredRepository studentRegisteredRepository;
	
	@Autowired
	private CoursesRepository coursesRepository;
	
	public StudentRegisteredCoursesEntity enrollStudent(Long studentId,Long courseId) {
		RegisteredStudentsEntity student = registeredStudentsRepository.findById(studentId).orElseThrow(()->new ResourceNotFoundException("Student not Found"));
		CoursesEntity course = coursesRepository.findById(courseId).orElseThrow(()->new ResourceNotFoundException("Course not Found"));
		StudentRegisteredCoursesEntity enroll = new StudentRegisteredCoursesEntity();
		enroll.setStudent(student);
		enroll.setCourse(course);
		enroll.setEnrolledAt(LocalDateTime.now());
		return studentRegisteredRepository.save(enroll);
	}
}
