package com.sl.app;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;




@Repository
public interface StudentRepositry extends JpaRepository<Student, Integer> {

	
	List<Student> findAllByFirstName(String firstName);
	
}
