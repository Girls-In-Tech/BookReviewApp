package com.example.employeemanagementlist.Domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "Employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String employeeName;
    private String employeeID;
    private String employeeDepartment;
    private String employeePosition;
    private String employeeMail;
    private int employeeContact;
    private String employeeGender;
    private String employeeStatus;

    public Employee() {

    }
    // Getter And Setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getEmployeeDepartment() {
        return employeeDepartment;
    }

    public void setEmployeeDepartment(String employeeDepartment) {
        this.employeeDepartment = employeeDepartment;
    }

    public String getEmployeePosition() {
        return employeePosition;
    }

    public void setEmployeePosition(String employeePosition) {
        this.employeePosition = employeePosition;
    }

    public String getEmployeeMail() {
        return employeeMail;
    }

    public void setEmployeeMail(String employeeMail) {
        this.employeeMail = employeeMail;
    }

    public int getEmployeeContact() {
        return employeeContact;
    }

    public void setEmployeeContact(int employeeContact) {
        this.employeeContact = employeeContact;
    }

    public String getEmployeeGender() {
        return employeeGender;
    }

    public void setEmployeeGender(String employeeGender) {
        this.employeeGender = employeeGender;
    }

    public String getEmployeeStatus() {
        return employeeStatus;
    }

    public void setEmployeeStatus(String employeeStatus) {
        this.employeeStatus = employeeStatus;
    }

    public Employee(Long id, String employeeName, String employeeID, String employeeDepartment, String employeePosition, String employeeMail, int employeeContact, String employeeGender, String employeeStatus) {
        this.id = id;
        this.employeeName = employeeName;
        this.employeeID = employeeID;
        this.employeeDepartment = employeeDepartment;
        this.employeePosition = employeePosition;
        this.employeeMail = employeeMail;
        this.employeeContact = employeeContact;
        this.employeeGender = employeeGender;
        this.employeeStatus = employeeStatus;
    }
}
