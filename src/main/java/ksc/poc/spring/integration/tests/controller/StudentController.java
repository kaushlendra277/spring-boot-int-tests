package ksc.poc.spring.integration.tests.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ksc.poc.spring.integration.tests.entities.Student;
import ksc.poc.spring.integration.tests.services.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@PostMapping
	public ResponseEntity<Student> save(@RequestBody Student student){
		Student savedStudent = studentService.save(student);
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(savedStudent);
	}

}
