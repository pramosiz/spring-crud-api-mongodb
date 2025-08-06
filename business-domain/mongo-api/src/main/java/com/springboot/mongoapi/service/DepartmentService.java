package com.springboot.mongoapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.mongoapi.entity.Department;
import com.springboot.mongoapi.repository.DepartmentRepository;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;

	public List<Department> getDepartments() {
		return departmentRepository.findAll();
	}

}
