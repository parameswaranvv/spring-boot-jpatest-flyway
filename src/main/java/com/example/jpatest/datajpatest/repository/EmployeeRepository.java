package com.example.jpatest.datajpatest.repository;

import com.example.jpatest.datajpatest.model.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

    public Employee findByEmployeeId(Integer employeeId);

    public List<Employee> findAllByEmployeeName(String employeeName);

}
