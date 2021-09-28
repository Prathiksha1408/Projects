package com.vco.project.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vco.project.exception.ResourceNotFoundException;
import com.vco.project.model.Teacher;
import com.vco.project.practical.ResponsePayload;
import com.vco.project.repository.TeacherRepository;


@RestController
@RequestMapping("/api")
public class TeacherController {

	@Autowired
	private TeacherRepository teacherRepository;
	
//	 @PostMapping("/Teacher")
//	    public Teacher createteacher(@Valid @RequestBody Teacher teacher) {
//	        return teacherRepository.save(teacher);
//	    }
	
	@PostMapping("/Teacher")
	private Object saveTeacher(@RequestBody Teacher teacher) {
		Teacher t=null;
		try {
			 t=teacherRepository.save(teacher);
		}catch(Exception ex) {
			ex.printStackTrace();
			return new ResponsePayload(HttpStatus.BAD_REQUEST.value(),"Failed",ex.getMessage());
		}
		return new ResponsePayload(HttpStatus.ACCEPTED.value(),"SUCCESS",t);
	}
	
	@GetMapping("/Teacher")
	private Object showAllTeacher(){
		List<Teacher>t=null;
		try {
			t=teacherRepository.findAll();
		}catch(Exception ex) {
			ex.printStackTrace();
			return new ResponsePayload(HttpStatus.BAD_REQUEST.value(),"FAIL",ex.getMessage());
		}
		return new ResponsePayload(HttpStatus.ACCEPTED.value(),"SUCCESS",t);
	}
	
	@GetMapping("/Teacher/{id}")
	private Object showTeacherById(@PathVariable int id) {
		Teacher t1=null;
		try {
			Optional<Teacher> t=teacherRepository.findById(id);
			 t1=t.get();
		}catch(Exception ex) {
			ex.printStackTrace();
			return new ResponsePayload(HttpStatus.BAD_REQUEST.value(),"Failed",ex.getMessage());
		}
		return new ResponsePayload(HttpStatus.ACCEPTED.value(),"SUCCESS",t1);
	}
	
	@PutMapping("/Teacher/{id}")
    public ResponseEntity<Teacher> updateTeacher(
    @PathVariable(value = "id") Integer TeacherId,
    @Valid @RequestBody Teacher teacherDetails) throws ResourceNotFoundException {
         Teacher teacher = teacherRepository.findById(TeacherId)
          .orElseThrow(() -> new ResourceNotFoundException("Teacher not found on :: "+ TeacherId));
  
        teacher.setTname(teacherDetails.getTname());
        teacher.setMobile(teacherDetails.getMobile());
        final Teacher updatedTeacher = teacherRepository.save(teacher);
        return ResponseEntity.ok(updatedTeacher);
   }

   @DeleteMapping("/Teacher/{id}")
   public Map<String, Boolean> deleteTeacher(
       @PathVariable(value = "id") Integer teacherId) throws Exception {
       Teacher teacher = teacherRepository.findById(teacherId)
          .orElseThrow(() -> new ResourceNotFoundException("student not found on :: "+ teacherId));

       teacherRepository.delete(teacher);
       Map<String, Boolean> response = new HashMap<>();
       response.put("deleted", Boolean.TRUE);
       return response;
   }
}

