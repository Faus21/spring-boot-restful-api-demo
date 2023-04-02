package com.portfolio.cruddemo.rest;

import com.portfolio.cruddemo.dao.EmployeeDAO;
import com.portfolio.cruddemo.entity.Employee;
import com.portfolio.cruddemo.service.EmployeeService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {


    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees(){
        return employeeService.getEmployee();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){
        Employee employee = employeeService.getEmployee(employeeId);

        if (employee == null)
            throw  new RuntimeException("Employee id not found - " + employeeId);

        return employee;
    }

    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee){

        employee.setId(0);

        Employee dbEmployee = employeeService.createOrUpdateEmployee(employee);

        return dbEmployee;
    }

    @PutMapping("/employees/{employeeId}")
    public Employee updateEmployee(@RequestBody Employee employee, @PathVariable int employeeId){

        if (employee.getId() != employeeId)
            throw  new RuntimeException("You can't change id of the employee!");

        Employee dbEmployee = employeeService.createOrUpdateEmployee(employee);

        if (dbEmployee == null)
            throw  new RuntimeException("Employee with" + employeeId + " not found!");

        return dbEmployee;
    }


    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){

        Employee tempEmployee = employeeService.getEmployee(employeeId);

        if (tempEmployee == null)
            throw  new RuntimeException("Employee id not found - " + employeeId);

        employeeService.deleteEmployee(employeeId);

        return "Deleted!";
    }
}
