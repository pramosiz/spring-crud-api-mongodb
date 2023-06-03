package com.springboot.crudapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.crudapi.dto.StudentDTO;
import com.springboot.crudapi.entity.Student;
import com.springboot.crudapi.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	StudentService studentService;
	
	@PostMapping("/create")
	public Student createStudent(@RequestBody StudentDTO student) {
		return studentService.createStudent(student);
	}
	
	@GetMapping("/getById/{id}")
	public Student getStudentByID(@PathVariable String id) {
		return studentService.getStudentById(id);
	}
	
	@GetMapping
	public List<Student> getAllStudents() {
		return studentService.getAllStudents();
	}
	
	@PutMapping("/update")
	public Student updateStudent(@RequestBody StudentDTO student) {
		return studentService.updateStudent(student);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteStudent(@PathVariable String id) {
		return studentService.deleteStudent(id);
	}
	
	@GetMapping("/studentsByName/{name}")
	public List<Student> getStudentsByName(@PathVariable String name) {
		return studentService.getStudentsByName(name);
	}
	
	@GetMapping("/studentsByNameAndMail")
	public List<Student> getStudentsByNameAndMail(@RequestParam String name, @RequestParam String email) {
		return studentService.getStudentsByNameAndMail(name, email);
	}
	
	@GetMapping("/studentsByNameOrMail")
	public List<Student> getStudentsByNameOrMail(@RequestParam String name, @RequestParam String email) {
		return studentService.getStudentsByNameOrMail(name, email);
	}
	
	@GetMapping("/allWithPagination")
	public List<Student> getStudentsByNameOrMail(@RequestParam int pageNo, @RequestParam int pageSize) {
		return studentService.getAllWithPagination(pageNo, pageSize);
	}
	
	@GetMapping("/allWithSorting")
	public List<Student> getStudentsWithSorting() {
		return studentService.getAllWithSorting();
	}
	
//	@GetMapping("/byDepartmentName")
//	public List<Student> getStudentsByDepartmentName(@RequestParam String deptName) {
//		return studentService.getStudentsByDepartmentName(deptName);
//	}
//	
//	@GetMapping("/bySubjectName")
//	public List<Student> getStudentsBySubjectName(@RequestParam String subName) {
//		return studentService.getStudentsBySubjectName(subName);
//	}
	
	@GetMapping("/byEmailLike")
	public List<Student> getStudentsByEmailDomain(@RequestParam String email) {
		return studentService.getStudentsByEmailDomain(email);
	}
	
	@GetMapping("/byNameStartsWith")
	public List<Student> getStudentsByNameStartsWith(@RequestParam String name) {
		return studentService.getStudentsByNameStartsWith(name);
	}
	
}
