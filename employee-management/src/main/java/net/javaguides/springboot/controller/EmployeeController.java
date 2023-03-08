package net.javaguides.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import net.javaguides.springboot.entity.Employee;
import net.javaguides.springboot.service.EmployeeService;

@Controller
public class EmployeeController {
	EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}

	@GetMapping("/employees")
	public String getStudent(Model m) {
		m.addAttribute("employees", employeeService.getAllEmployee());
		return "employees";
	}
	
	@GetMapping("/addemployee")
	public String addEmployee(Model m)
	{
		Employee emp=new Employee();
		m.addAttribute("employee", emp);
		return "create_employee";
		
	}
	
	@PostMapping("/addemployee")
	public String saveEmloyee(@ModelAttribute("employee") Employee employee)
	{
		employeeService.addEmployee(employee);
		return "redirect:/employees";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Long id)
	{
		employeeService.deleteById(id);
		return "redirect:/employees";
	}
	
	@GetMapping("/update/{id}")
	public String updateById(@PathVariable Long id,Model m)
	{
		m.addAttribute("employee", employeeService.findEmployeeById(id));
		return "edit_employee";
	}
	
	@PostMapping("/employee/save/{id}")
	public String updateEmployee(@ModelAttribute("employee") Employee employee, @PathVariable Long id)
	{
		Employee emp=employeeService.findEmployeeById(id);
		emp.setId(employee.getId());
		emp.setName(employee.getName());
		emp.setSalary(employee.getSalary());
		emp.setCompany(employee.getCompany());
		employeeService.updateSave(emp);
		return "redirect:/employees";
	}

}
