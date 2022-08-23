package com.student.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.entity.Student;
import com.student.exception.ResourceNotFoundException;
@Service
public class StudentServiceImpl implements IStudentService {
	
	@Autowired
	IStudentRepository studentrepository;

	@Override
	public Integer saveStudent(Student student) {
   Student students =  studentrepository.save(student);
		return students.getId();
	}

	@Override
	public Optional<Student> getStudent(Integer id) {
		// TODO Auto-generated method stub
		return studentrepository.findById(id) ;
	}

	@Override
	public List<Student> getStudentclass(Integer classname) {
		List<Student> students= studentrepository.findAll();
		return students.stream().filter(n-> n.getClassname().equals(classname)).collect(Collectors.toList());
	}

	@Override
	public void deleteStudent(Integer id) {
	studentrepository.deleteById(id);
		
	}

	@Override
	public List<Student> getallStudents() {
		
		return studentrepository.findAll();
	}

	@Override
	public Student updateStudent(Student student, Integer id) {
		Student existingstudent = studentrepository.findById(id).orElseThrow(
				()-> new ResourceNotFoundException("Student", "id", id));
		        existingstudent.setFirstName(student.getFirstName());	
		        existingstudent.setLastName(student.getLastName());
		        existingstudent.setDob(student.getDob());
		        existingstudent.setClassname(student.getClassname());  
		        studentrepository.save(existingstudent);
				return existingstudent;
	
	}



	
	}


