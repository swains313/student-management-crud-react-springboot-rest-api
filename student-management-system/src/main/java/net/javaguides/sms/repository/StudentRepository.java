package net.javaguides.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.sms.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>
{
	
}
