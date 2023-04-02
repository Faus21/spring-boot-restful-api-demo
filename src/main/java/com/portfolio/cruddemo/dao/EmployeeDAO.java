package com.portfolio.cruddemo.dao;

import com.portfolio.cruddemo.entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeDAO {

    List<Employee> getEmployees();

    Employee getEmployee(int employeeId);

    Employee createOrUpdateEmployee(Employee employee);

    void  deleteEmployee(int employeeId);
}
