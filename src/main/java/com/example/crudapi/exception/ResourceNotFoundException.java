package com.example.crudapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String resourceName;
	private String FieldName;
	private Object FieldValue;
	
	public ResourceNotFoundException(String resourceName, String fieldName, Object fieldValue) {
		super(String.format("%s not found with %s : '%s'",resourceName, fieldName,fieldValue));
		this.resourceName = resourceName;
		FieldName = fieldName;
		FieldValue = fieldValue;
	}


	public String getResourceName() {
		return resourceName;
	}

	public String getFieldName() {
		return FieldName;
	}

	
	public Object getFieldValue() {
		return FieldValue;
	}

	
	
}
