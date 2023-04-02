package com.portfolio.cruddemo.service;

import com.portfolio.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService{
    List<Employee> getEmployee();

    Employee getEmployee(int employeeId);

    Employee createOrUpdateEmployee(Employee employee);

    void  deleteEmployee(int employeeId);
}
