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
import com.VCO.project.model.CourseDTO;
import com.VCO.project.repository.CourseRepository;

@RestController                 //creates Restful web services
@RequestMapping("/api/v1")     //maps http request to handler method

public class CourseController {

	@Autowired                //used to inject object dependency
    private CourseRepository courseRepository;

    @GetMapping("/Courses")
    public List<CourseDTO> getAllcourse() {
        return courseRepository.findAll();
    }

    @GetMapping("/Course/{id}")
    public ResponseEntity<CourseDTO> getCourseDTOById(
    @PathVariable(value = "id") Integer CourseId) throws ResourceNotFoundException {
        CourseDTO course = courseRepository.findById(CourseId)
        .orElseThrow(() -> new ResourceNotFoundException("Course not found on :: "+ CourseId));
        return ResponseEntity.ok().body(course);
    }

    @PostMapping("/course")
    public CourseDTO createCourse(@Valid @RequestBody CourseDTO course) {
        return courseRepository.save(course);
    }

    @PutMapping("/course/{id}")
    public ResponseEntity<CourseDTO> updateCourse(
    @PathVariable(value = "id") Integer CourseId,
    @Valid @RequestBody CourseDTO courseDetails) throws ResourceNotFoundException {
         CourseDTO course = courseRepository.findById(CourseId)
          .orElseThrow(() -> new ResourceNotFoundException("Course not found on :: "+ CourseId));
  
        course.setname(courseDetails.getname());
        course.setcode(courseDetails.getcode());
        course.setduration(courseDetails.getduration());
        course.sethod(courseDetails.gethod());
        course.settotal_fees(courseDetails.gettotal_fees());
        course.setcoursetype(courseDetails.getcoursetype());
        final CourseDTO updatedCourse = courseRepository.save(course);
        return ResponseEntity.ok(updatedCourse);
   }

   @DeleteMapping("/course/{id}")
   public Map<String, Boolean> deleteCourse(
       @PathVariable(value = "id") Integer courseId) throws Exception {
       CourseDTO course = courseRepository.findById(courseId)
          .orElseThrow(() -> new ResourceNotFoundException("course not found on :: "+ courseId));

       courseRepository.delete(course);
       Map<String, Boolean> response = new HashMap<>();
       response.put("deleted", Boolean.TRUE);
       return response;
   }
}
