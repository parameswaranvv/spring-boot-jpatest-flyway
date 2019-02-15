package com.example.jpatest.datajpatest.repository;

import com.example.jpatest.datajpatest.model.Address;
import com.example.jpatest.datajpatest.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Slf4j
public class EmployeeRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    void shouldInsertEmployeeRecord() {
        Employee employee = new Employee();
        employee.setEmployeeName("some-employee-name");
        Address employeeAddress = new Address();
        employeeAddress.setZipCode("52525");
        employee.setEmployeeAddress(employeeAddress);
        employeeRepository.save(employee);
        log.info("Employee Record from Database: {}", employeeRepository.findAllByEmployeeName("some-employee-name"));
        assertThat(employeeRepository.findAllByEmployeeName("some-employee-name").get(0)).isEqualTo(employee);
    }

}
