package com.sl.repositry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sl.entity.Student;

import java.util.List;




@Repository
public interface StudentRepositry extends JpaRepository<Student, Integer> {

	
	List<Student> findAllByFirstName(String firstName);
	
	List<Student> findAllByLastName(String lastName);
	
}


