package com.portfolio.cruddemo.service;

import com.portfolio.cruddemo.dao.EmployeeDAO;
import com.portfolio.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<Employee> getEmployee() {
        return employeeDAO.getEmployees();
    }

    @Override
    public Employee getEmployee(int employeeId) {
        return employeeDAO.getEmployee(employeeId);
    }

    @Transactional
    @Override
    public Employee createOrUpdateEmployee(Employee employee) {
        return employeeDAO.createOrUpdateEmployee(employee);
    }

    @Transactional
    @Override
    public void deleteEmployee(int employeeId) {
        employeeDAO.deleteEmployee(employeeId);
    }


}
