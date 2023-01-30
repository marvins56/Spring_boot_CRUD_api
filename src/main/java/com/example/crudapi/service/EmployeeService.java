package com.example.crudapi.service;

import java.util.List;

import com.example.crudapi.model.Employee;

public interface EmployeeService {
    Employee SaveEmployee(Employee employee);
    //method to return list of employees
    List<Employee> getAllEmployees();
}
