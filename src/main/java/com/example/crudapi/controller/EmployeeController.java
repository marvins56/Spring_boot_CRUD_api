package com.example.crudapi.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.crudapi.service.EmployeeService;

@RestController
public class EmployeeController {

    private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}

    
	
	
}
