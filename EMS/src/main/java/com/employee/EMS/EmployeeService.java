package com.employee.EMS;

import java.util.List;

public interface EmployeeService {
    
    Employee createEmployee(Employee employee);
    Employee getEmployee(Long id);
    void  deleteEmployee(Long id);
    Employee updateEmployee(Long id,Employee employee);
    Employee raiseSalary(Long id,Double percentage);
    List<Employee> getAllEmployees();
    
}
