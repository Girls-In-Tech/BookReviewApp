package com.example.employeemanagementlist.Controller.API;

import com.example.employeemanagementlist.Domain.Employee;
import com.example.employeemanagementlist.Repository.EmployeeRepository;
import com.example.employeemanagementlist.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmployeeAPI {
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    EmployeeService employeeService;
    @RequestMapping("/employee")
    @GetMapping("/employee")
    public ResponseEntity<List<Employee>> getAllEmployee(){
        return ResponseEntity.ok().body(employeeService.getAllEmployees());
    }
    @GetMapping
    public ResponseEntity<Employee> getEmployeeById(@PathVariable long id){
        return ResponseEntity.ok().body(employeeService.getEmployeeById(id));
    }
    @PostMapping("/employee")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
        return ResponseEntity.ok().body(employeeService.saveEmployee(employee));
    }
    @PutMapping("/employee/{id}")
    public ResponseEntity<Employee> updateEmployeeRecord(@PathVariable long Id, @RequestBody Employee employee){
        return ResponseEntity.ok().body(employeeService.updateEmployeeRecord(employee));
    }
    @DeleteMapping("/employee/{id}")
    public HttpStatus deleteEmployee(@PathVariable long id ){
        employeeService.deleteEmployee(id);
        return HttpStatus.OK;
    }

}
