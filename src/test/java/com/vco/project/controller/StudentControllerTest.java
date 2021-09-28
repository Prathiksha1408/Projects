package com.vco.project.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringRunner;

import com.vco.project.model.Assignment;

@RunWith(value = SpringRunner.class)
class StudentControllerTest {

	@InjectMocks
	private AssignmentController assignmentcontroller;
	
	@BeforeEach
	    public void setUpEmployee() throws Exception{
	    	Assignment assignment = new Assignment();
	    	assignment.setAid(8L);
	    	assignment.setName("support");
	    	assignment.setGrade(4);
	    }
}


