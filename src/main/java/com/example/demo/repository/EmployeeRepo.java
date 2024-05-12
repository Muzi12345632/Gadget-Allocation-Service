package com.example.demo.repository;

import com.example.demo.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {
    Employee save(Employee employee);
    Employee findByName(String name);
}
