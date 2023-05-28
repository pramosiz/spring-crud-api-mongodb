package com.springboot.crudapi.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@SuperBuilder
@Document(collection = "department")
public class Department {

	@Id
	@Field("_id")
	private ObjectId id;
	
	@Field(name = "department_name")
	private String departmentName;
	
	@Field(name = "location")
	private String location;
	
}
