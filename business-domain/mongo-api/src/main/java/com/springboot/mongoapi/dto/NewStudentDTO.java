package com.springboot.mongoapi.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NewStudentDTO {

	private String name;
	private String mail;
	private NewDepartmentDTO newDepartment;
	private List<NewSubjectDTO> newSubjects;
}
