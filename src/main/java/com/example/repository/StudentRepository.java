package com.example.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.example.model.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student,Long> {
	
	//@Query("update student s set s.name = :name and s.rollno = :rollno where s.id=id")
    //public Student updateStudent(@Param("id") Long id,@Param("name") String name,@Param("rollno") int rollno );	
	 
	//public Student addStudent(Student student);	
  //  public Student updateStudent(Student student);
//	public Void deleteStudent(Student student);
	public Optional<Student> findById(Long id);	
	
	//@Query("select std.id,std.name,std.rollno from student std where std.name= :name")
	public List<Student> findByName(@Param("name") String name);	
	public Student findByRollno(@Param("rollno") int rollno);
	public List<Student> findAll();


}
