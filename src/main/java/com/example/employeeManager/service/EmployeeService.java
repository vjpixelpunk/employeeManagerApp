package com.example.employeeManager.service;

import com.example.employeeManager.exception.UserNotFoundException;
import com.example.employeeManager.model.Employee;
import com.example.employeeManager.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {
    private final EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {

        this.employeeRepo = employeeRepo;
    }

    public Employee addEmployee(Employee employee) {
        employee.setEmployeeCode(UUID.randomUUID().toString());
        System.out.println("adding employee " + employee + ". : Service layer");
        return employeeRepo.save(employee);
    }

    public List<Employee> findAllEmployees() {
        System.out.println("Getting all employees : Service layer");
        return employeeRepo.findAll();
    }

    public Employee updateEmployee(Employee employee) {
        System.out.println("Updating employee " + employee + ". : Service layer");
        return employeeRepo.save(employee);

    }

    public Employee findEmployeeById(Long id){
        System.out.println("Finding employee " + id + ". : Service layer");
        return employeeRepo.findEmployeeById(id)
                .orElseThrow(() -> new UserNotFoundException(" User by id " + id+" was not found"));
    }

    public void deleteEmployee(Long id) {
        System.out.println("Deleting employee " + id + ". : Service layer");
        employeeRepo.deleteEmployeeById(id);
    }
}
