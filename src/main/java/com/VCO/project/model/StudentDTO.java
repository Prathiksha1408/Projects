package com.VCO.project.model;

import java.io.Serializable;
//import java.util.Set;
import java.sql.Date;

import javax.persistence.Column;
//import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
//import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity          
@Table(name="students")   
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
public class StudentDTO implements Serializable
{
private static final long serialVersionUID = 1L;

	@Id                                  //Specifies the primary key of an entity
	@Column(name="std_id")    
	private String std_id;         
	
	@Column(name="first_name")
	private String first_name;
	
	@Column(name="last_name")
	private String last_name;
	
	@Column(name="dob")
	private Date dob;
	
	@Column(name="doj")
	private Date doj;
	
	@Column(name="city")
	private String city;
	
	@Column(name="state")
	private String state;
	
	@Column(name="email")
	private String email;
	
	@Column(name="pno")
	private String pno;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "c_id", nullable = false)
    @JsonIgnore
    private CourseDTO course;
	//@OneToOne(mappedBy = "feepayment", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    //private Set<Fee_payment> feepayment;
	
	public StudentDTO()
	{
		System.out.println(this.getClass().getSimpleName()+" Object created using argument");
	}

	public StudentDTO(String std_id , String first_name, String last_name, Date dob , Date doj ,String city,
			String state, String email , String pno ) 
	{
		System.out.println(this.getClass().getSimpleName()+" Object created using argument");
		this.std_id = std_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.dob = dob;
		this.doj = doj;
		this.city = city;
		this.state = state;
		this.email = email;
		this.pno = pno;
		//this.course_id = course_id;
		
	}

	public String getstd_id() {
		return std_id;
	}

	public void setStd_Id(String std_id) {
		this.std_id = std_id;
	}
	
	public String getfirst_name() {
		return first_name;
	}

	public String getlast_name() {
		return last_name;
	}

	public void setfirst_name(String first_name) {
		this.first_name = first_name;
	}
	
	public void setlast_name(String last_name) {
		this.last_name = last_name;
	}

	public Date getdob() {
		return dob;
	}

	public void setdob(Date dob) {
		this.dob = dob;
	}
	
	public Date getdoj() {
		return doj;
	}

	public void setdoj(Date doj) {
		this.doj = doj;
	}

	public String getcity() {
		return city;
	}
	
	public void setcity(String city) {
		this.city = city;
	}

	public String getstate() {
		return state;
	}
	
	public void setstate(String state) {
		this.state = state;
	}
	
	public String getemail() {
		return email;
	}
	
	public void setemail(String email) {
		this.email = email;
	}
	
	public String getpno() {
		return pno;
	}
	
	public void setpno(String pno) {
		this.pno = pno;
	}
}


