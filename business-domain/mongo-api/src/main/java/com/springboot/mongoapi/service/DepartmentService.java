package com.springboot.mongoapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.mongoapi.entity.Department;
import com.springboot.mongoapi.repository.DepartmentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DepartmentService {

	private final DepartmentRepository departmentRepository;

	public List<Department> getDepartments() {
		return departmentRepository.findAll();
	}

}
