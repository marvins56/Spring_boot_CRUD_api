package com.example.crudapi.controller;

import java.util.List;

import org.hibernate.engine.query.spi.ReturnMetadata;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
                        //getting specific employee by id 
                //localhost:8080/api/employee/1
                @GetMapping("{id}")
                public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long Eployeeid) {
                    return new ResponseEntity<Employee>(employeeService.getEmployeeById(Eployeeid), HttpStatus.OK);

                }
                //build update employee 
                //localhost:8080/api/employee/1
                @PutMapping("{id}")
                public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id,
                        @RequestBody Employee employee) {
                    return new ResponseEntity<Employee>(employeeService.updateEmployee(employee, id), HttpStatus.OK);
                }

                //building  delete rest api
                   //localhost:8080/api/employee/1
@DeleteMapping("{id}")
public ResponseEntity<String> DeleteEmployee(@PathVariable("id") long id) {
    //delete employee from dB
    employeeService.DeleteEmployee(id);
        return  new ResponseEntity<String>("Employee deleted successfully", HttpStatus.OK);
 }  
}
