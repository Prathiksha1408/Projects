package com.VCO.project.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity          
@Table(name="feeschedule")  
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
public class Fee_schedule implements Serializable
{
	private static final long serialVersionUID = 1L;
	@Id      
	@Column(name="schedule_id")    
	private int schedule_id;         
	
	@Column(name="year_of_payment")
	private int year_of_payment;
	
	@Column(name="fee_expected")
	private String fee_expected;
	
	//private int course_id;
    
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "c_id", nullable = false)
    @JsonIgnore
    private CourseDTO course;
    
    public Fee_schedule()
	{
		System.out.println(this.getClass().getSimpleName()+" Object created using argument");
	}
	
	public Fee_schedule(int schedule_id, int year_of_payment, String fee_expected, int duration)//, int course_id ) 
	{
		System.out.println(this.getClass().getSimpleName()+" Object created using argument");
		this.schedule_id = schedule_id;
		this.year_of_payment = year_of_payment;
		this.fee_expected = fee_expected;
		//this.course_id = course_id;
	}

	public int getschedule_id() {
		return schedule_id;
	}

	public void setschedule_id(int schedule_id) {
		this.schedule_id = schedule_id;
	}
	
	public int getyear_of_payment() {
		return year_of_payment;
	}

	public void setyear_of_payment(int year_of_payment) {
		this.year_of_payment = year_of_payment;
	}
	
	public String getfee_expected() {
		return fee_expected;
	}

	public void setfee_expected(String fee_expected) {
		this.fee_expected = fee_expected;
	}
	
	//public int getcourse_id() {
		//return course_id;
	//}
	
	//public void setcourse_id(int course_id) {
		//this.course_id = course_id;
	//}
	
}




