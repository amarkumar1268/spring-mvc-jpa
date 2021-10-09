package com.example.model;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STD_SEQ")
    @SequenceGenerator(sequenceName = "student_seq", initialValue = 1, allocationSize = 1, name = "STD_SEQ")
   	private Long id;
	@Column(name="name")
	private String name;
	@Column(name="rollno")
	private int rollno;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	
	public String toString()
	{
		return "Student ["+this.id+" "+this.name+" "+this.rollno+"]";
	}
	
	public Student(Long a,String b,int c)
	{
		this.id=a;
		this.name=b;
		this.rollno=c;		
	}
	public Student()
	{
		
	}

}
