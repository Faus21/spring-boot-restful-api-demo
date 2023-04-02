package com.portfolio.cruddemo.dao;

import com.portfolio.cruddemo.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO{

    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOJpaImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }


    @Override
    public List<Employee> getEmployees() {

        TypedQuery<Employee> query = entityManager.createQuery("from Employee", Employee.class);

        List<Employee> employees = query.getResultList();

        return employees;
    }

    @Override
    public Employee getEmployee(int employeeId) {

        Employee employee = entityManager.find(Employee.class, employeeId);

        return employee;
    }

    @Override
    public Employee createOrUpdateEmployee(Employee employee) {

        Employee dbEmployee = entityManager.merge(employee);

        return dbEmployee;
    }

    @Override
    public void deleteEmployee(int employeeId) {

        Employee employee = entityManager.find(Employee.class, employeeId);

        entityManager.remove(employee);
    }


}
