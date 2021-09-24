package com.VCO.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.VCO.project.model.CourseDTO;

@Repository
public interface CourseRepository extends JpaRepository<CourseDTO , Integer> {
	
}
