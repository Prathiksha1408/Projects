package com.VCO.project.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.VCO.project.exception.ResourceNotFoundException;
import com.VCO.project.model.StudentDTO;
import com.VCO.project.repository.Student;

@RestController                 //creates Restful web services
@RequestMapping("/api/v1")     //maps http request to handler method

public class StudentController {

	@Autowired                //used to inject object dependency
    private Student studentRep;

    @GetMapping("/Student")
    public List<StudentDTO> getAllstudent() {
        return studentRep.findAll();
    }

    @GetMapping("/Student/{id}")
    public ResponseEntity<StudentDTO> getStudentDTOById(
    @PathVariable(value = "id") String StudentId) throws ResourceNotFoundException {
        StudentDTO student = studentRep.findById(StudentId)
        .orElseThrow(() -> new ResourceNotFoundException("Student not found on :: "+ StudentId));
        return ResponseEntity.ok().body(student);
    }

    @PostMapping("/Student")
    public StudentDTO createStudent(@Valid @RequestBody StudentDTO student) {
        return studentRep.save(student);
    }

    @PutMapping("/Student/{id}")
    public ResponseEntity<StudentDTO> updateStudent(
    @PathVariable(value = "id") String StudentId,
    @Valid @RequestBody StudentDTO studentDetails) throws ResourceNotFoundException {
         StudentDTO student = studentRep.findById(StudentId)
          .orElseThrow(() -> new ResourceNotFoundException("Student not found on :: "+ StudentId));
  
        student.setfirst_name(studentDetails.getfirst_name());
        student.setlast_name(studentDetails.getlast_name());
        student.setdob(studentDetails.getdob());
        student.setdoj(studentDetails.getdoj());
        student.setcity(studentDetails.getcity());
        student.setstate(studentDetails.getstate());
        student.setemail(studentDetails.getemail());
        student.setpno(studentDetails.getpno());
        final StudentDTO updatedStudent = studentRep.save(student);
        return ResponseEntity.ok(updatedStudent);
   }

   @DeleteMapping("/Student/{id}")
   public Map<String, Boolean> deleteStudent(
       @PathVariable(value = "id") String StudentId) throws Exception {
       StudentDTO student = studentRep.findById(StudentId)
          .orElseThrow(() -> new ResourceNotFoundException("student not found on :: "+ StudentId));

       studentRep.delete(student);
       Map<String, Boolean> response = new HashMap<>();
       response.put("deleted", Boolean.TRUE);
       return response;
   }
}

