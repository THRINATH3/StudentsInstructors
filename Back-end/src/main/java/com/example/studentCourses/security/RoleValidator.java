package com.example.studentCourses.security;

import org.springframework.security.access.AccessDeniedException;

public class RoleValidator {

    public static void allowInstructor(String role) {
        if (!"INSTRUCTOR".equals(role)) {
            throw new AccessDeniedException("Only instructors can perform this action");
        }
    }

    public static void allowStudent(String role) {
        if (!"STUDENT".equals(role)) {
            throw new AccessDeniedException("Only students can perform this action");
        }
    }
}
