package com.example.jpatest.datajpatest.repository;

import com.example.jpatest.datajpatest.model.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class EmployeeRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    void shouldInsertEmployeeRecord() {
        Employee employee = new Employee();
        employee.setEmployeeName("some-employee-name");
        employeeRepository.save(employee);
        assertThat(employeeRepository.findAllByEmployeeName("some-employee-name").get(0)).isEqualTo(employee);
    }

}
