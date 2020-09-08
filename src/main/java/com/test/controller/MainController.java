package com.test.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.test.dao.Studentdao;
import com.test.model.Student;

@Controller 
public class MainController {
	
	@Autowired
	Studentdao StudentDao;
	
	@RequestMapping("/")
	public ModelAndView register() {    
		System.out.println("hii");
		ModelAndView mv=new ModelAndView();
		mv.setViewName("index.jsp"); 
		return mv;
	} 
	@RequestMapping("/save") 
	public ModelAndView save(Student student) {
		ModelAndView mv=new ModelAndView();
		StudentDao.save(student); 
 		mv.setViewName("index.jsp"); 
		return mv;
	}
	@RequestMapping("/get") 
	public ModelAndView getData(@RequestParam int id) {
		Student student=StudentDao.findById(id).orElse(new Student());
		ModelAndView mv=new ModelAndView();
		mv.addObject(student);
		mv.setViewName("showData.jsp"); 
		return mv; 
	}
	
	@RequestMapping(path="/students", produces = "application/xml")
	@ResponseBody
	public List<Student> getStudents() {
		return StudentDao.findAll();
	}
	
	@RequestMapping("/student/{id}")
	@ResponseBody
	public Optional<Student> getStudent(@PathVariable("id") int id) {
		return StudentDao.findById(id);        
	}
	
	@PostMapping("/addStudent")
	public Student addStudent(@RequestBody Student s){
		StudentDao.save(s);
		return s;
	}
	
	@DeleteMapping("/delStudent/{id}")
	public String deleteStudent(@PathVariable("id") int id) {
		Student s=StudentDao.getOne(id);
		StudentDao.delete(s);
		return "deleted"; 
	}
	
	@PutMapping("/saveorupdateStudent")
	public Student saveorupdateStudent(@RequestBody Student s){
		StudentDao.save(s);
		return s;
	}
	

}
