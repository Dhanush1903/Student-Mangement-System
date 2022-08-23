package com.student.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.student.entity.Student;
import com.student.service.IStudentService;

@RestController
public class StudentController {
	
	@Autowired
	IStudentService studentService;
//	create a student
	@PostMapping("/save")
	public Integer saveStudent(@RequestBody Student student) {
		return studentService.saveStudent(student);
		
	}
//	get by id
	@GetMapping("/getStudent/{id}")
	public Optional<Student> getStudent(@PathVariable Integer id){
		Optional<Student> student = studentService.getStudent(id);
		return student;
	}
	
//get by class
	@GetMapping("/getStudentclass/{classname}")
	public List<Student> getStudentclass(@PathVariable Integer classname){
		List<Student> student = studentService.getStudentclass(classname);
		return student;
	}
	
//	get all students
	@GetMapping("/allStudents")
	public List<Student> getallStudents(){
		return studentService.getallStudents();
		}
	
	
	
	
//	delete by id
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Student> deleteStudent(@PathVariable Integer id){
		
		ResponseEntity<Student> responseEntity= new ResponseEntity<>(HttpStatus.OK);
		try {
			studentService.deleteStudent(id);
		}
		catch (Exception e) {
			e.printStackTrace();
			responseEntity= new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return  responseEntity;
	
	}
	
//	update student details
	@PutMapping("/update/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable("id") Integer id, @RequestBody Student student){
		return new ResponseEntity<Student>(studentService.updateStudent(student, id), HttpStatus.OK);
	}
	
}
