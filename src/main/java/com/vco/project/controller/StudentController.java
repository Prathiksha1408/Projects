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
import com.vco.project.model.Student;
import com.vco.project.practical.ResponsePayload;
import com.vco.project.repository.StudentRepository;

@RestController
//Annotation for mapping web requests to handler methods  
@RequestMapping("/api")            
public class StudentController {

	@Autowired
	private StudentRepository studentRepository;

	@PostMapping("/Student")
	private ResponsePayload createStudent(@RequestBody Student student) {
		Student s = null;
		try {
			//System.out.println(student);
			s = studentRepository.save(student);      
			//System.out.println("Saving done");
		} catch (Exception ex) {
			ex.printStackTrace();
			return new ResponsePayload(HttpStatus.BAD_REQUEST.value(), "Failed", ex.getMessage());
		}
		return new ResponsePayload(HttpStatus.ACCEPTED.value(), "SUCCESS", s);
	}

	@GetMapping("/Student")
	private Object getAllStudents() {
		List<Student>s=null;
		try {
			s=studentRepository.findAll(); //Returns all instances of the type
		} catch (Exception ex) {
			ex.printStackTrace();
			return new ResponsePayload(HttpStatus.BAD_REQUEST.value(), "Failed", ex.getMessage());
		}
		return new ResponsePayload(HttpStatus.ACCEPTED.value(), "SUCCESS", s);
	}
	
	@GetMapping("/Student/{id}")
	private Object getStudentById(@PathVariable Integer id) {
		Student s1=null;
		try {
			Optional<Student>s=studentRepository.findById(id);
			s1=s.get();
		}catch(Exception ex) {
			ex.printStackTrace();
			return new ResponsePayload(HttpStatus.BAD_REQUEST.value(), "Failed", ex.getMessage());
		}
		return new ResponsePayload(HttpStatus.ACCEPTED.value(), "SUCCESS", s1);
	}
	
	@PutMapping("/Student/{id}")
    public ResponseEntity<Student> updateStudent(
    @PathVariable(value = "id") Integer StudentId,
    @Valid @RequestBody Student studentDetails) throws ResourceNotFoundException {
         Student student = studentRepository.findById(StudentId)
          .orElseThrow(() -> new ResourceNotFoundException("Student not found on :: "+ StudentId));
  
        student.setName(studentDetails.getName());
        student.setAge(studentDetails.getAge());
        final Student updatedStudent = studentRepository.save(student);
        return ResponseEntity.ok(updatedStudent);
   }

   @DeleteMapping("/Student/{id}")
   public Map<String, Boolean> deleteStudent(
       @PathVariable(value = "id") Integer studentId) throws Exception {
       Student student = studentRepository.findById(studentId)
          .orElseThrow(() -> new ResourceNotFoundException("student not found on :: "+ studentId));

       studentRepository.delete(student);
       Map<String, Boolean> response = new HashMap<>();
       response.put("deleted", Boolean.TRUE);
       return response;
   }

}


