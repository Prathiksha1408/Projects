package com.vco.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="assignment") 
public class Assignment {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "aid")
	private Long aid;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "grade")
	private int grade;

	@ManyToOne
    @JoinColumn(name = "id")
    private Student student;
	
	@ManyToOne
    @JoinColumn(name = "tid")
    private Teacher teacher;

	public Long getAid() {
		return aid;
	}

	public void setAid(Long aid) {
		this.aid = aid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	@JsonIgnore
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@JsonIgnore
	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
	
}

