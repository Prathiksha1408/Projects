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
import com.VCO.project.model.Fee_payment;
import com.VCO.project.repository.Fee_paymentRepository;


@RestController                 //creates Restful web services
@RequestMapping("/api/v1")     //maps http request to handler method

public class PaymentController {

	@Autowired                //used to inject object dependency
    private Fee_paymentRepository paymentRep;

    @GetMapping("/Payment")
    public List<Fee_payment> getAlldetails() {
        return paymentRep.findAll();
    }

    @GetMapping("/Payment/{id}")
    public ResponseEntity<Fee_payment> getPaymentById(
    @PathVariable(value = "id") Double PaymentId) throws ResourceNotFoundException {
        Fee_payment payment = paymentRep.findById(PaymentId)
        .orElseThrow(() -> new ResourceNotFoundException(" not found on :: "+ PaymentId));
        return ResponseEntity.ok().body(payment);
    }

    @PostMapping("/Payment")
    public Fee_payment createPayment(@Valid @RequestBody Fee_payment payment) {
        return paymentRep.save(payment);
    }

    @PutMapping("/Payment/{id}")
    public ResponseEntity<Fee_payment> updateSchedule(
    @PathVariable(value = "id") Double PaymentId,
    @Valid @RequestBody Fee_payment paymentDetails) throws ResourceNotFoundException {
         Fee_payment payment= paymentRep.findById(PaymentId)
          .orElseThrow(() -> new ResourceNotFoundException(" not found on :: "+ PaymentId));
  
        payment.setpayment_type(paymentDetails.getpayment_type());
        payment.setpayment_date(paymentDetails.getpayment_date());
        final Fee_payment updatedPayment = paymentRep.save(payment);
        return ResponseEntity.ok(updatedPayment);
   }

   @DeleteMapping("/Payment/{id}")
   public Map<String, Boolean> deletePayment(
       @PathVariable(value = "id") Double PaymentId) throws Exception {
       Fee_payment payment = paymentRep.findById(PaymentId)
          .orElseThrow(() -> new ResourceNotFoundException(" not found on :: "+ PaymentId));

       paymentRep.delete(payment);
       Map<String, Boolean> response = new HashMap<>();
       response.put("deleted", Boolean.TRUE);
       return response;
   }
}


