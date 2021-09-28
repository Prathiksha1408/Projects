package com.vco.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vco.project.model.Assignment;
import com.vco.project.practical.Payload;

@RestController
@RequestMapping("/api")
public class AssignmentController {

	@Autowired
	private AssignmentService assignService;
	@PostMapping("/Assignment")
	private Object saveAssignement(@RequestBody Payload payload) {
		int teacherId=payload.getId();
		int studentId=payload.getStdId();
		Assignment assignment=payload.getAssignment();
		return  assignService.saveAssignment(teacherId, assignment,studentId);
	}
	@GetMapping("/Assignment")
	private Object saveAssignement1(@RequestBody Payload payload) {
		int teacherId=payload.getId();
		int studentId=payload.getStdId();
		Assignment assignment=payload.getAssignment();
		return  assignService.saveAssignment(teacherId, assignment,studentId);
	}
	
}

