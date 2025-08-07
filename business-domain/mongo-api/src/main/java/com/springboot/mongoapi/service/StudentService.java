package com.springboot.mongoapi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.springboot.mongoapi.dto.NewStudentDTO;
import com.springboot.mongoapi.dto.StudentDTO;
import com.springboot.mongoapi.entity.Department;
import com.springboot.mongoapi.entity.Student;
import com.springboot.mongoapi.entity.Subject;
import com.springboot.mongoapi.repository.DepartmentRepository;
import com.springboot.mongoapi.repository.StudentRepository;
import com.springboot.mongoapi.repository.SubjectRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentService {

	private final StudentRepository studentRepository;
	private final DepartmentRepository departmentRepository;
	private final SubjectRepository subjectRepository;

	public Student createStudent(NewStudentDTO studentDTO) {

		// Buscar o crear Department
		Department department = departmentRepository
				.findByDepartmentName(studentDTO.getNewDepartment().getDepartment_name())
				.orElseGet(() -> departmentRepository.save(
						Department.builder()
								.departmentName(studentDTO.getNewDepartment().getDepartment_name())
								.location(studentDTO.getNewDepartment().getLocation())
								.build()));

		// Buscar o crear Subjects
		List<Subject> subjects = new ArrayList<>();
		studentDTO.getNewSubjects().forEach(subjectDTO -> {
			Subject subject = subjectRepository
					.findBySubjectName(subjectDTO.getSubject())
					.orElseGet(() -> subjectRepository.save(
							Subject.builder()
									.subjectName(subjectDTO.getSubject())
									.marksObtained(subjectDTO.getMarks_obtained())
									.build()));
			subjects.add(subject);
		});

		Student student = Student.builder()
				.name(studentDTO.getName())
				.email(studentDTO.getMail())
				.department(department)
				.subjects(subjects)
				.build();

		return studentRepository.save(student);
	}

	public Student getStudentById(String id) {
		Optional<Student> student = studentRepository.findById(id);
		if (student.isPresent()) {
			return student.get();
		} else {
			return null;
		}
	}

	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	public Student updateStudent(StudentDTO studentDto) {
		Department department = Department.builder()
				.id(studentDto.getDepartment().getId())
				.departmentName(studentDto.getDepartment().getDepartment_name())
				.location(studentDto.getDepartment().getLocation())
				.build();
		List<Subject> subjects = new ArrayList<>();
		studentDto.getSubjects().stream().forEach(subjectIterator -> {
			Subject subject = Subject.builder()
					.id(subjectIterator.getId())
					.subjectName(subjectIterator.getSubject())
					.marksObtained(subjectIterator.getMarks_obtained())
					.build();
			subjects.add(subject);
		});
		Student student = Student.builder()
				.id(studentDto.getId())
				.name(studentDto.getName())
				.email(studentDto.getMail())
				.department(department)
				.subjects(subjects)
				.build();
		if (student.getDepartment() != null) {
			departmentRepository.save(student.getDepartment());
		}
		if ((student.getSubjects() != null) && !student.getSubjects().isEmpty()) {
			subjectRepository.saveAll(student.getSubjects());
		}
		return studentRepository.save(student);
	}

	public String deleteStudent(String id) {
		String result;
		Student student = getStudentById(id);
		if (student == null) {
			result = "Student not found";
		} else {
			studentRepository.deleteById(id);
			result = "Student deleted";
		}
		return result;
	}

	public List<Student> getStudentsByName(String name) {
		return studentRepository.findByNombre(name);
	}

	public List<Student> getStudentsByNameAndMail(String name, String email) {
		return studentRepository.findByNameAndEmail(name, email);
	}

	public List<Student> getStudentsByNameOrMail(String name, String email) {
		return studentRepository.findByNameOrEmail(name, email);
	}

	public List<Student> getAllWithPagination(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize);

		return studentRepository.findAll(pageable).getContent();
	}

	public List<Student> getAllWithSorting() {
		Sort sort = Sort.by(Sort.Direction.ASC, "name");
		return studentRepository.findAll(sort);
	}

	// public List<Student> getStudentsByDepartmentName(String deptName) {
	// return studentRepository.findByDepartmentDepartmentName(deptName);
	// }
	//
	// public List<Student> getStudentsBySubjectName(String subName) {
	// return studentRepository.findBySubjectsSubjectName(subName);
	// }

	public List<Student> getStudentsByEmailDomain(String email) {
		return studentRepository.findByEmailIsLike(email);
	}

	public List<Student> getStudentsByNameStartsWith(String name) {
		return studentRepository.findByNameStartsWith(name);
	}

}
