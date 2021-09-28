package com.vco.project.practical;

import com.vco.project.model.Assignment;

public class Payload {

	private Integer id;
	public Payload() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Payload(Integer id, int stdId, Assignment assignment) {
		super();
		this.id = id;
		this.stdId = stdId;
		this.assignment = assignment;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public int getStdId() {
		return stdId;
	}
	public void setStdId(int stdId) {
		this.stdId = stdId;
	}
	public Assignment getAssignment() {
		return assignment;
	}
	public void setAssignment(Assignment assignment) {
		this.assignment = assignment;
	}
	private int stdId;
	private Assignment assignment;
	// this Payload is to hold the result after inserting the data referred in TWO tables
}
