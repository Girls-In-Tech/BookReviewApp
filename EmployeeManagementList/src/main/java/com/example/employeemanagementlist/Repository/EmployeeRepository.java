package com.example.employeemanagementlist.Repository;

import com.example.employeemanagementlist.Domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
