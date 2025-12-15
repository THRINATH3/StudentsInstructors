package com.example.studentCourses.dtos;

import java.time.LocalDateTime;

public class StudentCourseDTO {

    private Long studentId;
    private String firstName;
    private String lastName;
    private String email;
    private LocalDateTime actionAt; // enrolledAt / completedAt

    public StudentCourseDTO(Long studentId, String firstName, String lastName,
                            String email, LocalDateTime actionAt) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.actionAt = actionAt;
    }

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDateTime getActionAt() {
		return actionAt;
	}

	public void setActionAt(LocalDateTime actionAt) {
		this.actionAt = actionAt;
	}

    
}
