package net.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.springboot.entiry.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
