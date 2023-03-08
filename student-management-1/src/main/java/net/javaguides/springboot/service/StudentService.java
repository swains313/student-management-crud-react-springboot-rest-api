package net.javaguides.springboot.service;

import java.util.List;

import net.javaguides.springboot.entity.Student;

public interface StudentService {
	
	List<Student> getAllStudent();
	
	public Student saveStudent(Student student);
	
	public void deleteStudent(Long id);
	
	public Student getStudentById(Long id);
	
	public Student updateStudent(Student student);

}
