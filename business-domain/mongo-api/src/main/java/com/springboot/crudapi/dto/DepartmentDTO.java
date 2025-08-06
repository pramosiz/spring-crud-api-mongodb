package com.springboot.crudapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DepartmentDTO {			// JSON field's names

	
	private String id;
	
	private String department_name;
	
	private String location;
}
