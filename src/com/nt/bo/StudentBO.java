package com.nt.bo;

public class StudentBO {
	
	private String name;
	private String course;
	private float total_marks;
	private float avg_marks;
	private String grade;
	public StudentBO() {
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public float getTotal_marks() {
		return total_marks;
	}
	public void setTotal_marks(float total_marks) {
		this.total_marks = total_marks;
	}
	public float getAvg_marks() {
		return avg_marks;
	}
	public void setAvg_marks(float avg_marks) {
		this.avg_marks = avg_marks;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	

}
