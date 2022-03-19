package com.numan.main.BackEnd.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.numan.main.BackEnd.Exception.ResourceNotFoundException;
import com.numan.main.BackEnd.Model.Employee;
import com.numan.main.BackEnd.Repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;
	
	
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}
	
	
	@Override

	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}


	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
		 
	}


	@Override
	public Employee getEmployeeById(long id) {
		
//		Optional<Employee> employee=employeeRepository.findById(id);
		
//		if(employee.isPresent()) {
//			return employee.get();
//		}else {
//			throw new ResourceNotFoundException("Employee","id",id);
//		}
		
		//Lambda expression
		
		return employeeRepository.findById(id).orElseThrow(() -> 
		                          new ResourceNotFoundException("Employee","Id",id));
		
	}


	@Override
	public Employee updateById(Employee employee, long id) {
		// first we check to employee with given id  exist in DB or not
		
		Employee existingEmployee =  employeeRepository.findById(id).orElseThrow(()->
		                          new ResourceNotFoundException("Employee","Id",id));
		
		existingEmployee.setFirst_name(employee.getFirst_name());
		existingEmployee.setLast_name(employee.getLast_name());
		existingEmployee.setEmail(employee.getEmail());
		
		//save employee database
		employeeRepository.save(existingEmployee);
		return existingEmployee;
	}


	@Override
	public void deleteById(long id) {
		// first we check to employee with given id  exist in DB or not
		
		employeeRepository.findById(id).orElseThrow(()->
		                new ResourceNotFoundException("Employee","Id",id));
		
		//delete Employee
		employeeRepository.deleteById(id);
		
	}


}
