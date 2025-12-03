package com.example.studentCourses.exceptions;

public class EmailAlreadyExistsException extends RuntimeException {
    public EmailAlreadyExistsException() { super(); }
    public EmailAlreadyExistsException(String message) { super(message); }
}
