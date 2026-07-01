package com.employee.EMS;

import java.lang.foreign.Linker.Option;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EMSRepository extends JpaRepository<Employee, Long >{
    Optional<Employee> findByName(String name);
}
