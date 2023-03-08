package net.javaguides.springboot.conntroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import net.javaguides.springboot.entity.Student;
import net.javaguides.springboot.service.StudentService;

@Controller
public class StudentController {
	
	StudentService studentService;

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	
	@GetMapping("/students")
	public String getAllStudent(Model m)
	{
		m.addAttribute("students", studentService.getAllStudent());
		return "students";
	}
	
	@GetMapping("/students/new")
	public String addStudent(Model m)
	{
		Student std=new Student();
		m.addAttribute("student", std);
		return "create_student";
	}
	
	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student)
	{
		studentService.saveStudent(student);
		return "redirect:/students";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteStudent(@PathVariable Long id)
	{
		studentService.deleteStudent(id);
		return "redirect:/students";
	}
	
	@GetMapping("/students/edit/{id}")
	public String editStudent(@PathVariable Long id, Model m)
	{
		m.addAttribute("student", studentService.getStudentById(id));
		return "edit_student";
	}
	
	@PostMapping("/updatestudent/{id}")
	public String updateSave(@PathVariable Long id, @ModelAttribute Student student)
	{
		Student std=studentService.getStudentById(id);
		std.setFirstName(student.getFirstName());
		std.setLastName(student.getLastName());
		std.setEmail(student.getEmail());
		std.setId(student.getId());
		
		studentService.updateStudent(std);
		return "redirect:/students";
		
		
	}

	
	

}
