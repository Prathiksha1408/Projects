package com.VCO.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.VCO.project.model.Fee_schedule;

@Repository
public interface Fee_scheduleRepository extends JpaRepository<Fee_schedule , Integer> {
	
}

