package com.test.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.model.Student;

public interface Studentdao extends JpaRepository<Student, Integer> {
	
	
}
