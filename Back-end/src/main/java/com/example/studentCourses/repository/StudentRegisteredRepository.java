package com.example.studentCourses.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.studentCourses.Entity.StudentRegisteredCoursesEntity;

@Repository
public interface StudentRegisteredRepository extends JpaRepository<StudentRegisteredCoursesEntity,Long> {
	 List<StudentRegisteredCoursesEntity> findByCourse_cId(Long courseId);
}
