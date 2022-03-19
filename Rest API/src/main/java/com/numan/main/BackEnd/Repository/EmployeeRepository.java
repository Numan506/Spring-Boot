package com.numan.main.BackEnd.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.numan.main.BackEnd.Model.Employee;

public interface EmployeeRepository extends JpaRepository <Employee,Long> {

}
