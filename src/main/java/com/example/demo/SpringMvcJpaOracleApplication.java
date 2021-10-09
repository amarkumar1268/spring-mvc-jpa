 package com.example.demo;

import java.util.Optional;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.Student;
import com.example.repository.StudentRepository;
//import com.example.serviceimpl.StudentServiceImpl;
import com.example.serviceimpl.StudentServiceImpl;

@SpringBootApplication
@EntityScan("com.example.model")
@EnableJpaRepositories("com.example.repository")
@ComponentScan(value={"com.example.serviceimpl","com.example.controller"})
public class SpringMvcJpaOracleApplication implements CommandLineRunner{
	
	@Autowired
	DataSource dataSource;
	
	@Autowired
	StudentServiceImpl stdservice;
	
	@Autowired
	StudentRepository repo;

	public static void main(String[] args) {
		SpringApplication.run(SpringMvcJpaOracleApplication.class, args);
	}
		
	@Transactional
	@Override
    public void run(String... args) throws Exception
	{
		
		
		stdservice.addStudent(new Student(1L,"amar2",1928));
		stdservice.addStudent(new Student(2L,"amar3",1924));
		stdservice.addStudent(new Student(3L,"amar4",1925));

		System.out.println("find by student id");		
		Optional<Student> stdopt=stdservice.findById(1L);
		System.out.println(stdopt.get());
		
		System.out.println("find by student name");	
		for(Student s1: stdservice.findByName("amar4"))
		System.out.println(s1);	
		
		System.out.println("find all student");	
		for(Student s1: stdservice.findAll())
		System.out.println(s1);

	}
}
