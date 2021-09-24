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
import com.VCO.project.model.Fee_schedule;
import com.VCO.project.repository.Fee_scheduleRepository;

@RestController                 //creates Restful web services
@RequestMapping("/api/v1")     //maps http request to handler method

public class FeeScheduleController {

	@Autowired                //used to inject object dependency
    private Fee_scheduleRepository scheduleRep;

    @GetMapping("/Schedule")
    public List<Fee_schedule> getAlldetails() {
        return scheduleRep.findAll();
    }

    @GetMapping("/Schedule/{id}")
    public ResponseEntity<Fee_schedule> getFee_scheduleById(
    @PathVariable(value = "id") Integer ScheduleId) throws ResourceNotFoundException {
        Fee_schedule schedule = scheduleRep.findById(ScheduleId)
        .orElseThrow(() -> new ResourceNotFoundException(" not found on :: "+ ScheduleId));
        return ResponseEntity.ok().body(schedule);
    }

    @PostMapping("/Schedule")
    public Fee_schedule createSchedule(@Valid @RequestBody Fee_schedule schedule) {
        return scheduleRep.save(schedule);
    }

    @PutMapping("/Schedule/{id}")
    public ResponseEntity<Fee_schedule> updateSchedule(
    @PathVariable(value = "id") Integer ScheduleId,
    @Valid @RequestBody Fee_schedule scheduleDetails) throws ResourceNotFoundException {
         Fee_schedule schedule = scheduleRep.findById(ScheduleId)
          .orElseThrow(() -> new ResourceNotFoundException(" not found on :: "+ ScheduleId));
  
        schedule.setyear_of_payment(scheduleDetails.getyear_of_payment());
        schedule.setfee_expected(scheduleDetails.getfee_expected());
        final Fee_schedule updatedSchedule = scheduleRep.save(schedule);
        return ResponseEntity.ok(updatedSchedule);
   }

   @DeleteMapping("/Schedule/{id}")
   public Map<String, Boolean> deleteSchedule(
       @PathVariable(value = "id") Integer ScheduleId) throws Exception {
       Fee_schedule schedule = scheduleRep.findById(ScheduleId)
          .orElseThrow(() -> new ResourceNotFoundException(" not found on :: "+ ScheduleId));

       scheduleRep.delete(schedule);
       Map<String, Boolean> response = new HashMap<>();
       response.put("deleted", Boolean.TRUE);
       return response;
   }
}

