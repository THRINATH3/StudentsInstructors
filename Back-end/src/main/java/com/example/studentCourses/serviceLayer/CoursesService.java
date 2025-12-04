package com.example.studentCourses.serviceLayer;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.studentCourses.Entity.CoursesEntity;
import com.example.studentCourses.repository.CoursesRepository;

@Service
public class CoursesService {

    @Autowired
    private CoursesRepository courseRepository;

    public List<CoursesEntity> getCoursesList() {
        return courseRepository.findAll();
    }

    public CoursesEntity registerCourse(CoursesEntity course) {
        return courseRepository.save(course);
    }

    public Optional<CoursesEntity> getCourse(Long id) {
        return courseRepository.findById(id);
    }
}
