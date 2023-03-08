package net.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
