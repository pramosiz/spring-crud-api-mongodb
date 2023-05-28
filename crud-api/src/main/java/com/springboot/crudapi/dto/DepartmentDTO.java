package com.springboot.crudapi.dto;

import org.bson.types.ObjectId;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DepartmentDTO {			// JSON field's names

	
	private ObjectId id;
	
	private String department_name;
	
	private String location;
}
