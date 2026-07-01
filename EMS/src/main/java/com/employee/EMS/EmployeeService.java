package com.employee.EMS;

import java.util.List;

public interface EmployeeService {
    
    Employee createEmployee(Employee employee);
    Employee getEmployee(Long id);
    void  deleteEmployee(Long id);
    Employee updateEmployee(Long id,Employee employee);
    
    List<Employee> getAllEmployees();
    
}
