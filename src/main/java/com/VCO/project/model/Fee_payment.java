package com.VCO.project.model;

import java.io.Serializable;
import java.sql.Date;

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
@Table(name="feepayment")   
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
public class Fee_payment implements Serializable
{
	private static final long serialVersionUID = 1L;
	@Id  
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="payment_id")    
	private String payment_id;         
	
	@Column(name="bank_account")
	private String bank_account;
	
	@Column(name="payment_date")
	private Date payment_date;
	
	@Column(name="payment_type")
	private String payment_type;
	
	@Column(name="amount")
	private long amount;
	
	//private int std_id;
	@OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "std_id", nullable = false)
    @JsonIgnore
    private StudentDTO student;
	
	public Fee_payment()
	{
		System.out.println(this.getClass().getSimpleName()+" Object created using argument");
	}

	public Fee_payment(String payment_id, String bank_account, Date payment_date, String payment_type, long amount)//, int std_id) 
	{
		System.out.println(this.getClass().getSimpleName()+" Object created using argument");
		this.payment_id = payment_id;
		this.bank_account = bank_account;
		this.payment_date = payment_date;
		this.payment_type = payment_type;
		this.amount = amount;
		//this.std_id = std_id;
	}

	public String getpayment_id() {
		return payment_id;
	}

	public void setpayment_id(String payment_id) {
		this.payment_id = payment_id;
	}
	
	public String getbank_account() {
		return bank_account;
	}

	public void setbank_account(String bank_account) {
		this.bank_account = bank_account;
	}
	
	public Date getpayment_date() {
		return payment_date;
	}

	public void setpayment_date(Date payment_date) {
		this.payment_date = payment_date;
	}
	public String getpayment_type() {
		return payment_type;
	}

	public void setpayment_type(String payment_type) {
		this.payment_type = payment_type;
	}

	public long getamount() {
		return amount;
	}
	
	public void setamount(long amount) {
		this.amount = amount;
	}
	
	//public int getstd_id() {
		//return std_id;
	//}
	
	//public void setcourse_id(int std_id) {
		//this.std_id = std_id;
	//}

}




