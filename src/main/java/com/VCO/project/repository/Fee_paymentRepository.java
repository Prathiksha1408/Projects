package com.VCO.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.VCO.project.model.Fee_payment;

@Repository
public interface Fee_paymentRepository extends JpaRepository<Fee_payment , Double> {
	
}
