package com.VCO.project.model;

import javax.persistence.Column;

//import java.io.Serializable;
import java.util.Set;

//import javax.persistence.CascadeType;
import javax.persistence.Entity;
//import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
//import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity                    //Specifies that the class is an entity
@Table(name="courses")      //specifies name of the table  
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
public class CourseDTO //implements Serializable
{
	//private static final long serialVersionUID = 1L;
	@Id                         //Specifies the primary key
	@Column(name="c_id")    
	private int c_id;         
	
	@Column(name="code")
	private String code;
	
	@Column(name="name")
	private String name;
	
	@Column(name="duration")
	private double duration;
	
	@Column(name="hod")
	private String hod;
	
	@Column(name="coursetype")
	private String coursetype;
	
	@Column(name="total_fees")
	private double total_fees;
	//@JsonManagedReference
	//@OneToMany(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  //  private Set<StudentDTO> course;
	//@OneToOne(mappedBy = "feeschedule", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
   // private Set<Fee_schedule> courses;
	@JsonIgnore
	@OneToMany(mappedBy = "course")
    private Set<StudentDTO> students;
	public CourseDTO()
	{
		System.out.println(this.getClass().getSimpleName()+" Object created using argument");
	}
	public CourseDTO(int c_id , String code, String name, double duration, String hod, String coursetype, double total_fees)
	{
		System.out.println(this.getClass().getSimpleName()+" Object created using argument");
		this.c_id = c_id;
		this.code = code;
		this.name = name;
		this.duration = duration;
		this.hod = hod;
		this.coursetype = coursetype;
		this.total_fees = total_fees;
	}

	public int getc_id() {
		return c_id;
	}

	public void setc_id(int c_id) {
		this.c_id = c_id;
	}
	
	public String getcode() {
		return code;
	}

	public void setcode(String code) {
		this.code = code;
	}
	
	public String getname() {
		return name;
	}

	public void setname(String name) {
		this.name = name;
	}
	
	public double getduration() {
		return duration;
	}

	public void setduration(double duration) {
		this.duration = duration;
	}
	
	public String gethod() {
		return hod;
	}

	public void sethod(String hod) {
		this.hod = hod;
	}

	public String getcoursetype() {
		return coursetype;
	}
	
	public void setcoursetype(String coursetype) {
		this.coursetype = coursetype;
	}

	public double gettotal_fees() {
		return total_fees;
	}
	
	public void settotal_fees(double total_fees) {
		this.total_fees = total_fees;
		
	}
	
}



