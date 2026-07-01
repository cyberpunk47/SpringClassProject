package com.employee.EMS;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EMSRepository emsRepository;

    @Override
    public Employee createEmployee(Employee employee) {
        if (emsRepository.findByName(employee.getName()).isPresent()) {
            throw new RuntimeException("Employee already exists");
        }
        switch (employee.getDesignation()) {

            case PROGRAMMER:
                employee.setSalary(2500.0);
                break;

            case MANAGER:
                employee.setSalary(3000.0);
                break;

            case TESTER:
                employee.setSalary(2000.0);
                break;
        }
        return emsRepository.save(employee);
    }

    @Override
    public Employee getEmployee(Long id) {
        return emsRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));

    }

    @Override
    public void deleteEmployee(Long id) {
        Employee emp = emsRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
        emsRepository.delete(emp);
    }

    @Override
    public Employee updateEmployee(Long id, Employee employee) {
        Employee updateEmp = emsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        updateEmp.setName(employee.getName());
        updateEmp.setAge(employee.getAge());
        // updateEmp.setDesignation(employee.getDesignation());
        switch (updateEmp.getDesignation()) {
            case PROGRAMMER:
                updateEmp.setSalary(updateEmp.getSalary() + 5000.0);
                break;

            case MANAGER:
                updateEmp.setSalary(updateEmp.getSalary() + 8000.0);
                break;

            case TESTER:
                updateEmp.setSalary(updateEmp.getSalary() + 4000.0);
                break;
        }

        return emsRepository.save(updateEmp);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return emsRepository.findAll();
    }

}
