package com.example.crudapi.service.impl;

import org.springframework.stereotype.Service;

import com.example.crudapi.model.Employee;
import com.example.crudapi.repository.EmployeeRepository;
import com.example.crudapi.service.EmployeeService;

@Service
public class EmployeeServiceimpl implements EmployeeService {

    //FOR mandatory fields use contructor dependency injsctopn otherwise use setter 
    private EmployeeRepository employeeRepository;

	public EmployeeServiceimpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	public Employee SaveEmployee(Employee employee) {
        // TODO Auto-generated method stub
        return employeeRepository.save(employee);
    }

}
