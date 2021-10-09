package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.Student;
import com.example.serviceimpl.StudentServiceImpl;

@Controller
@RequestMapping("/")
public class StudentController {
	
	@Autowired
	StudentServiceImpl stdservice;
	
	@RequestMapping("/")
	public ModelAndView index()
	{
		ModelAndView mv=new ModelAndView("index.jsp");
	    return mv;
	}
    
	@RequestMapping("addStudent")
	public ModelAndView StudentDetails(Student std)
	{
		ModelAndView mv=new ModelAndView("index.jsp");
		stdservice.addStudent(std);	
	    return mv;
	}
	
	@RequestMapping("findByName")
	public ModelAndView findByName(@RequestParam String name)
	{
		ModelAndView mv=new ModelAndView("studentDataList.jsp");
		List<Student> s=stdservice.findByName(name);
		//for(Student s1:s)
			//mv.addObject(s1);
		mv.addObject("lists", s);
		s.forEach(n -> System.out.println(n));
	    return mv;
	}
	
	@RequestMapping("findById")
	public ModelAndView findById(@RequestParam Long id)
	{
		ModelAndView mv=new ModelAndView("studentData.jsp");
		Student s=stdservice.findById(id).orElse(new Student());
		mv.addObject(s);
	    return mv;
	}
	
	@RequestMapping("findByRollno")
	public ModelAndView findByRollno(@RequestParam int rollno)
	{
		ModelAndView mv=new ModelAndView("studentData.jsp");
		Student s=stdservice.findByRollno(rollno);
		mv.addObject(s);
	    return mv;
	}
	
	@RequestMapping("findAll")
	public ModelAndView findAll()
	{
		ModelAndView mv=new ModelAndView("studentDataList.jsp");
		List<Student> s=stdservice.findAll();
		//for(Student s1:s)
			//mv.addObject(s1);
		mv.addObject("lists", s);
		s.forEach(n -> System.out.println(n));
	    return mv;
	}
	
	
}
