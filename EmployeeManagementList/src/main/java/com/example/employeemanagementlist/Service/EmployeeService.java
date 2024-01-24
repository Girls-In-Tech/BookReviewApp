package com.example.employeemanagementlist.Service;

import com.example.employeemanagementlist.Domain.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {
    Employee saveEmployee(Employee employee);

    Employee getEmployeeById(long Id);

    List<Employee> getAllEmployees();

    Employee updateEmployeeRecord(Employee employee);

    void deleteEmployee(long Id);
}
