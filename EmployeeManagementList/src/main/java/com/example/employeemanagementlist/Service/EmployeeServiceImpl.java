package com.example.employeemanagementlist.Service;

import com.example.employeemanagementlist.Domain.Employee;
import com.example.employeemanagementlist.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(long Id) {
        Optional<Employee> employee = employeeRepository.findById(Id);
        Employee emptyEmployee = null;
        if (employee.isPresent()) {
            emptyEmployee = employee.get();
            return emptyEmployee;
        }
        else {
            throw new RuntimeException("Employee not found");
        }
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee updateEmployeeRecord(Employee employee) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(employee.getId());
        if (optionalEmployee.isPresent()) {
            Employee updateEmployee = new Employee();
            updateEmployee.setEmployeeName(employee.getEmployeeName());
            updateEmployee.setEmployeeID(employee.getEmployeeID());
            updateEmployee.setEmployeeContact(employee.getEmployeeContact());
            updateEmployee.setEmployeeDepartment(employee.getEmployeeDepartment());
            updateEmployee.setEmployeeMail(employee.getEmployeeMail());
            updateEmployee.setEmployeeGender(employee.getEmployeeGender());
            updateEmployee.setEmployeePosition(employee.getEmployeePosition());
            updateEmployee.setEmployeeStatus(employee.getEmployeeStatus());
            employeeRepository.save(updateEmployee);
            return updateEmployee;
        } else {
            throw new RuntimeException("Employee not found");
        }
    }
    @Override
    public void deleteEmployee(long Id) {
    employeeRepository.deleteById(Id);
    }
}
