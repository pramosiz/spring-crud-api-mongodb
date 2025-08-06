package com.springboot.mongoapi.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.mongoapi.entity.Department;
import com.springboot.mongoapi.service.DepartmentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/department")
@Tag(name = "Department", description = "v1")
public class DepartmentController {

	private final DepartmentService departmentService;

	@GetMapping
	@Operation(summary = "Get all departments", description = "Service to get all departments", responses = {
			@ApiResponse(responseCode = "200", description = "Success"),
			@ApiResponse(responseCode = "500", description = "Internal Server Error") })
	public ResponseEntity<List<Department>> getDepartments() {
		return ResponseEntity.ok(departmentService.getDepartments());
	}

}
