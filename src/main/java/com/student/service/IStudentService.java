package com.student.service;

import java.util.List;
import java.util.Optional;

import com.student.entity.Student;

public interface IStudentService {

	Integer saveStudent(Student student);

	Optional<Student> getStudent(Integer id);

	List<Student> getStudentclass(Integer classname);

	void deleteStudent(Integer id);
	
	public List<Student> getallStudents();

	Student updateStudent(Student student, Integer id);

}
