package com.example.studentCourses.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.studentCourses.Entity.StudentCompletedCoursesEntity;

@Repository
public interface StudentCompletedRepository extends JpaRepository<StudentCompletedCoursesEntity,Long> {

}
