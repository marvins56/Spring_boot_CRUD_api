package com.example.crudapi.controller;

import java.util.List;

import org.hibernate.engine.query.spi.ReturnMetadata;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.crudapi.model.Employee;
import com.example.crudapi.service.EmployeeService;

@RestController
@RequestMapping("/api/emplyees")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        super();
        this.employeeService = employeeService;
    }
    
    //building createt rest api
    //post mapping cause it handles post http requests
    @PostMapping
    public ResponseEntity<Employee> SaveEmployee(@RequestBody Employee employee) {

        return new ResponseEntity<Employee>(employeeService.SaveEmployee(employee), HttpStatus.CREATED);

    }

        //getting all employee REST API
        @GetMapping
public List<Employee> getAllEmployees(){
return employeeService.getAllEmployees();
}


	
	
}
