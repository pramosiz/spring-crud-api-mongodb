package com.springboot.mongoapi.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.mongoapi.dto.NewStudentDTO;
import com.springboot.mongoapi.dto.StudentDTO;
import com.springboot.mongoapi.entity.Student;
import com.springboot.mongoapi.service.StudentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/student")
@Tag(name = "Student", description = "v1")
public class StudentController {

	private final StudentService studentService;

	@PostMapping("/create")
	@Operation(summary = "Save new Student", description = "Service to save new Student", responses = {
			@ApiResponse(responseCode = "201", description = "Student saved"),
			@ApiResponse(responseCode = "400", description = "Bad request for save Student") })
	public ResponseEntity<Student> createStudent(@RequestBody NewStudentDTO student) {
		return ResponseEntity.ok(studentService.createStudent(student));
	}

	@GetMapping("/getById/{id}")
	@Operation(summary = "Get Student by ID", description = "Service to get 1 Student", responses = {
			@ApiResponse(responseCode = "200", description = "Success"),
			@ApiResponse(responseCode = "404", description = "User not found") })
	public ResponseEntity<Student> getStudentByID(@PathVariable String id) {
		return ResponseEntity.ok(studentService.getStudentById(id));
	}

	@GetMapping
	@Operation(summary = "Get all Students", description = "Service to get all Students", responses = @ApiResponse(responseCode = "200", description = "Success"))
	public ResponseEntity<List<Student>> getAllStudents() {
		return ResponseEntity.ok(studentService.getAllStudents());
	}

	@PutMapping("/update")
	@Operation(summary = "Update an existing Student", description = "Service to update an existing Student", responses = {
			@ApiResponse(responseCode = "200", description = "Student updated"),
			@ApiResponse(responseCode = "400", description = "Bad request for update Student"),
			@ApiResponse(responseCode = "404", description = "Student not found") })
	public ResponseEntity<Student> updateStudent(@RequestBody StudentDTO student) {
		return ResponseEntity.ok(studentService.updateStudent(student));
	}

	@DeleteMapping("/delete/{id}")
	@Operation(summary = "Delete a Student", description = "Service to delete a Student", responses = {
			@ApiResponse(responseCode = "200", description = "Student deleted"),
			@ApiResponse(responseCode = "404", description = "Student not found") })
	public ResponseEntity<String> deleteStudent(@PathVariable String id) {
		return ResponseEntity.ok(studentService.deleteStudent(id));
	}

	@GetMapping("/studentsByName/{name}")
	@Operation(summary = "Get Students by Name", description = "Service to get Students by Name", responses = {
			@ApiResponse(responseCode = "200", description = "Success"),
			@ApiResponse(responseCode = "404", description = "Students not found") })
	public ResponseEntity<List<Student>> getStudentsByName(@PathVariable String name) {
		return ResponseEntity.ok(studentService.getStudentsByName(name));
	}

	@GetMapping("/studentsByNameAndMail")
	@Operation(summary = "Get Students by Name and Email", description = "Service to get Students by Name and Email", responses = {
			@ApiResponse(responseCode = "200", description = "Success"),
			@ApiResponse(responseCode = "404", description = "Students not found") })
	public ResponseEntity<List<Student>> getStudentsByNameAndMail(@RequestParam String name,
			@RequestParam String email) {
		return ResponseEntity.ok(studentService.getStudentsByNameAndMail(name, email));
	}

	@GetMapping("/studentsByNameOrMail")
	@Operation(summary = "Get Students by Name or Email", description = "Service to get Students by Name or Email", responses = {
			@ApiResponse(responseCode = "200", description = "Success"),
			@ApiResponse(responseCode = "404", description = "Students not found") })
	public ResponseEntity<List<Student>> getStudentsByNameOrMail(@RequestParam String name,
			@RequestParam String email) {
		return ResponseEntity.ok(studentService.getStudentsByNameOrMail(name, email));
	}

	@GetMapping("/allWithPagination")
	@Operation(summary = "Get all Students with Pagination", description = "Service to get all Students with Pagination", responses = {
			@ApiResponse(responseCode = "200", description = "Success"),
			@ApiResponse(responseCode = "404", description = "Students not found") })
	public ResponseEntity<List<Student>> getAllWithPagination(@RequestParam int pageNo, @RequestParam int pageSize) {
		return ResponseEntity.ok(studentService.getAllWithPagination(pageNo, pageSize));
	}

	@GetMapping("/allWithSorting")
	@Operation(summary = "Get all Students with Sorting", description = "Service to get all Students with Sorting", responses = {
			@ApiResponse(responseCode = "200", description = "Success"),
			@ApiResponse(responseCode = "404", description = "Students not found") })
	public ResponseEntity<List<Student>> getStudentsWithSorting() {
		return ResponseEntity.ok(studentService.getAllWithSorting());
	}

	@GetMapping("/byEmailLike")
	@Operation(summary = "Get Students by Email Like", description = "Service to get Students by Email Like", responses = {
			@ApiResponse(responseCode = "200", description = "Success"),
			@ApiResponse(responseCode = "404", description = "Students not found") })
	public ResponseEntity<List<Student>> getStudentsByEmailDomain(@RequestParam String email) {
		return ResponseEntity.ok(studentService.getStudentsByEmailDomain(email));
	}

	@GetMapping("/byNameStartsWith")
	@Operation(summary = "Get Students by Name Starts With", description = "Service to get Students by Name Starts With", responses = {
			@ApiResponse(responseCode = "200", description = "Success"),
			@ApiResponse(responseCode = "404", description = "Students not found") })
	public ResponseEntity<List<Student>> getStudentsByNameStartsWith(@RequestParam String name) {
		return ResponseEntity.ok(studentService.getStudentsByNameStartsWith(name));
	}

}
