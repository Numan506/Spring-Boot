package com.numan.main.BackEnd.Service;

import java.util.List;

import com.numan.main.BackEnd.Model.Employee;

public interface EmployeeService  {

	Employee saveEmployee(Employee employee);
	List<Employee>getAllEmployees();
	Employee getEmployeeById(long id);
	Employee updateById(Employee employee,long id);
	public void deleteById(long id);
}
