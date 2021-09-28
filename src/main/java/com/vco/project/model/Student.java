package com.vco.project.model;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//Specifies that the class is an entity
@Entity
//Specifies the primary table for the annotated entity
@Table(name="student") 
public class Student {
	//Specifies the primary key of an entity
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")  
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "age")
	private int age;
	
	//Specifies a many-valued association with one-to-many multiplicity
    @OneToMany(mappedBy = "student")
    private Set<Assignment> assignments;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Set<Assignment> getAssignments() {
		return assignments;
	}

	public void setAssignments(Set<Assignment> assignments) {
		this.assignments = assignments;
	}

	
    
}
