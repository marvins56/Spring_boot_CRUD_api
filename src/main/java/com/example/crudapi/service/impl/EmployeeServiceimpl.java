package com.example.crudapi.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.crudapi.exception.ResourceNotFoundException;
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

    @Override
    public List<Employee> getAllEmployees() {
        // TODO Auto-generated method stub
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(long id) {
        // Optional<Employee> employee = employeeRepository.findById(id);
        // if (employee.isPresent()) {
        //     return employee.get();
        // } else {
        //     throw new ResourceNotFoundException("Employee", "id", id);
        // }
        //OR
        return employeeRepository.findById(id).orElseThrow(
            () ->  new ResourceNotFoundException("Employee", "id", id));
    }

    @Override
    public Employee updateEmployee(Employee employee, long id) {
        // check if  employee id exixts in db
        Employee exixtingEmployee =employeeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Employee", "id", id));
        
        exixtingEmployee.setFirstName(employee.getFirstName());
        exixtingEmployee.setLatName(employee.getLatName());
        exixtingEmployee.setEmail(employee.getEmail());
        // save to database
        employeeRepository.save(exixtingEmployee);
        return exixtingEmployee;

            }

    @Override
    public void DeleteEmployee(long id) {
          // check if  employee id exixts in db
         employeeRepository.findById(id).orElseThrow(
                  () -> new ResourceNotFoundException("Employee", "id", id));
                  employeeRepository.deleteById(id);
        
    }

   

}
