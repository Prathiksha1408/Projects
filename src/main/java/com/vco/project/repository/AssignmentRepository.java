package com.vco.project.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vco.project.model.Assignment;

@Repository
public interface AssignmentRepository extends JpaRepository<Assignment, Integer> {
	List<Assignment> findByStudentId(Long studentId);	
}
