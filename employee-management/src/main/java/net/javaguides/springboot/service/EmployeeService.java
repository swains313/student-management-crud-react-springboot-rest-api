package net.javaguides.springboot.service;

import java.util.List;

import net.javaguides.springboot.entity.Employee;

public interface EmployeeService {

	List<Employee> getAllEmployee();
	
	Employee addEmployee(Employee emp);
	
	void deleteById(Long id);
	
	Employee findEmployeeById(Long id);
	
	Employee updateSave(Employee employee);

}
