package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.model.Student;

@Service
public interface StudentService {


	//@Query("update student s set s.name = :name and s.rollno = :rollno where s.id=id")
	//public Student updateStudent(@Param("id") Long id,@Param("name") String name,@Param("rollno") int rollno );
 
  //  public Student addStudent(Student std);
	//public Student updateStudent(Student std);
//	public void deleteStudent(Student std);
	public Optional<Student> findById(Long id);	
//	@Query("select std.id,std.name,std.rollno from student std where std.name= :name")
	public List<Student> findByName(@Param("name") String name);
	public Student findByRollno(@Param("rollno") int rollno);
	public List<Student> findAll();
	


}
