package net.javaguides.springboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.entiry.Student;
import net.javaguides.springboot.repository.StudentRepository;

@RestController
@CrossOrigin("http://localhost:3000/")
@RequestMapping("/api/v1")
public class StudentController {
	
	@Autowired
	StudentRepository repository;
	
	
	@GetMapping("/students")
	public List<Student> listStudent()
	{
		return repository.findAll();
	}
	
	@PostMapping("/students")
	public Student createStudent(@RequestBody Student student)
	{
		return repository.save(student);
	}
	
	@DeleteMapping("/students/{id}")
	public void deleteStudents(@PathVariable Integer id)
	{
		repository.deleteById(id);
	}
	
	@GetMapping("/students/{id}")
	public Student findById(@PathVariable Integer id)
	{
		return repository.findById(id).get();
	}
	
	
	@PutMapping("/students/{id}")
	public Student updateStudent(@PathVariable Integer id, @RequestBody Student student)
	{
		Student exStudent=repository.findById(id).get();
		//exStudent.setId(student.getId());
		exStudent.setFirstName(student.getFirstName());
		exStudent.setLastName(student.getLastName());
		exStudent.setAge(student.getAge());
		exStudent.setGender(student.getGender());
		exStudent.setGmail(student.getGmail());
		return repository.save(exStudent);
	}

}
