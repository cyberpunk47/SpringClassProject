package com.employee.EMS;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EMSRepository emsRepository;

    public EmployeeServiceImpl(EMSRepository emsRepository) {
        this.emsRepository = emsRepository;
    }

    @Override
    public Employee createEmployee(Employee employee) {
        if (emsRepository.findByName(employee.getName()).isPresent()) {
            throw new CustomException("EMPLOYEE_ALREADY_EXISTS");
        }
        if (employee.getAge() < 18 || employee.getAge() > 60) {
            throw new CustomException("Age must be between 18 and 60");
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
        return emsRepository.findById(id).orElseThrow(() -> new CustomException("Employee not found"));

    }

    @Override
    public void deleteEmployee(Long id) {
        Employee emp = emsRepository.findById(id).orElseThrow(() -> new CustomException("Employee not found"));
        emsRepository.delete(emp);
    }

    @Override
    public Employee updateEmployee(Long id, Employee employee) {
        Employee updateEmp = emsRepository.findById(id)
                .orElseThrow(() -> new CustomException("Employee not found"));
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

    @Override
    public Employee raiseSalary(Long id, Double percentage) {
        Employee emp = emsRepository.findById(id)
                .orElseThrow(() -> new CustomException("EMPLOYEE_NOT_FOUND"));
        if ((percentage < 1 || percentage > 100)) {
            throw new CustomException("PERCENTAGE_MUST_IN_RANGE_OF_1_TO_10");
        }
        double current = emp.getSalary();
        Double newSalary = current + (current * percentage / 100);
        emp.setSalary(newSalary);
        return emsRepository.save(emp);
    }

}
