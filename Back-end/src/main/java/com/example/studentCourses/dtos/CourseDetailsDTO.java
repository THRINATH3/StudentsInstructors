package com.example.studentCourses.dtos;

import java.util.List;

public class CourseDetailsDTO {

    private Long courseId;
    private String title;
    private String description;
    private String category;
    private String duration;

    private String instructorName;
    private String instructorEmail;

    private List<StudentCourseDTO> registeredStudents;
    private List<StudentCourseDTO> completedStudents;
    
    public CourseDetailsDTO(Long courseId, String title, String description, String category, String duration,
			String instructorName, String instructorEmail, List<StudentCourseDTO> registeredStudents,
			List<StudentCourseDTO> completedStudents) {
		super();
		this.courseId = courseId;
		this.title = title;
		this.description = description;
		this.category = category;
		this.duration = duration;
		this.instructorName = instructorName;
		this.instructorEmail = instructorEmail;
		this.registeredStudents = registeredStudents;
		this.completedStudents = completedStudents;
	}
	public Long getCourseId() {
		return courseId;
	}
	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getInstructorName() {
		return instructorName;
	}
	public void setInstructorName(String instructorName) {
		this.instructorName = instructorName;
	}
	public String getInstructorEmail() {
		return instructorEmail;
	}
	public void setInstructorEmail(String instructorEmail) {
		this.instructorEmail = instructorEmail;
	}
	public List<StudentCourseDTO> getRegisteredStudents() {
		return registeredStudents;
	}
	public void setRegisteredStudents(List<StudentCourseDTO> registeredStudents) {
		this.registeredStudents = registeredStudents;
	}
	public List<StudentCourseDTO> getCompletedStudents() {
		return completedStudents;
	}
	public void setCompletedStudents(List<StudentCourseDTO> completedStudents) {
		this.completedStudents = completedStudents;
	}
}
