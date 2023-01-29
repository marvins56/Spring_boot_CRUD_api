package com.example.crudapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.crudapi.model.Employee;


public interface EmployeeRepository  extends JpaRepository<Employee,Long>{

}
