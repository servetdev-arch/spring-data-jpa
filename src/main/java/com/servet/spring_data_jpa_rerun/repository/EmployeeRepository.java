package com.servet.spring_data_jpa_rerun.repository;

import com.servet.spring_data_jpa_rerun.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
