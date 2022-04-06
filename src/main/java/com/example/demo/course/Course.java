package com.example.demo.course;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.users.User;

@Entity
@Table(name="course")
public class Course {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="course_code")
	private String courseCode;
	
	@Column(name="course_title")
	private String courseTitle;
	
	@Column(name="credit_unit")
	private String creditUnit;
	
	@Column(name="matric_no", unique=true)
	private String matricNo;
	
	
	private String email;
	
	
	
	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Course(Long id, String courseCode, String courseTitle, String creditUnit, String matricNo, String email) {
		super();
		this.id = id;
		this.courseCode = courseCode;
		this.courseTitle = courseTitle;
		this.creditUnit = creditUnit;
		this.matricNo = matricNo;
		this.email = email;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	public String getCourseTitle() {
		return courseTitle;
	}
	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}
	public String getCreditUnit() {
		return creditUnit;
	}
	public void setCreditUnit(String creditUnit) {
		this.creditUnit = creditUnit;
	}
	public String getMatricNo() {
		return matricNo;
	}
	public void setMatricNo(String matricNo) {
		this.matricNo = matricNo;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Course [id=" + id + ", courseCode=" + courseCode + ", courseTitle=" + courseTitle + ", creditUnit="
				+ creditUnit + ", matricNo=" + matricNo + "]";
	}
	
	

}
