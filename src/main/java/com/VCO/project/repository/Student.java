package com.VCO.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.VCO.project.model.StudentDTO;

@Repository
public interface Student extends JpaRepository<StudentDTO , String> {
	
}
