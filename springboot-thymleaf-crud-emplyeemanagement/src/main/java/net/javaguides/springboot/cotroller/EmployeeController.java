package net.javaguides.springboot.cotroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.service.EmployeeService;

@Controller
public class EmployeeController 
{
	@Autowired
	EmployeeService employeeService;
	
	//display list of employee
	@GetMapping("/")
	public String getAllStudent(Model m)
	{
		m.addAttribute("listemp", employeeService.getAllEmployees());
		return "index";
	}
	
	@GetMapping("/newemployeeform")
	public String newEmployee(Model m)
	{
		Employee employee=new Employee();
		m.addAttribute("employee", employee);
		return "new_employee";
	}
	
	@PostMapping("/saveemployee")
	public String saveEmployee(@ModelAttribute("employee") Employee emp)
	{
		employeeService.saveEmployee(emp);
		return "redirect:/";
	}
	
	@GetMapping("/showupdateform/{id}")
	public String updateEmployee(@PathVariable Long id, Model m)
	{
		m.addAttribute("employee", employeeService.getEmployeeById(id));
		return "update_employee";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable Long id)
	{
		employeeService.deleteById(id);
		return "redirect:/";
	}

}
