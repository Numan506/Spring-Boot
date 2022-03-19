package com.numan.main.BackEnd.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.numan.main.BackEnd.Model.Employee;
import com.numan.main.BackEnd.Service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	//create employee rest API
	@PostMapping()
	
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
		
		return new ResponseEntity<Employee>(employeeService.saveEmployee(employee),HttpStatus.CREATED);
	}
	
	
	//get all employee rest API
	@GetMapping()
	public List<Employee> getAllEmployee(){
		return employeeService.getAllEmployees();
	}
	
	//get Employee by Id
	
	@GetMapping("{id}")
	public ResponseEntity<Employee> getEmployeeId(@PathVariable("id") long employeeId){
		return new ResponseEntity<Employee>(employeeService.getEmployeeById(employeeId),HttpStatus.OK);
	}
	
	//Update employee
	
	@PutMapping("{id}")
	public ResponseEntity<Employee>updateEmployee(@PathVariable("id") long id,
			@RequestBody Employee employee){
		
		return new ResponseEntity<Employee>(employeeService.updateById(employee, id),HttpStatus.OK);

	}
	
	//Delete employee
	@DeleteMapping("{id}")
	public ResponseEntity<String>DeleteEmployee(@PathVariable("id")long id){
		employeeService.deleteById(id);
		
		return new ResponseEntity<String>("Delete Successfully",HttpStatus.OK);
	}
}

	
