package ksc.poc.spring.integration.tests.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ksc.poc.spring.integration.tests.entities.Student;
import ksc.poc.spring.integration.tests.repos.StudentRepository;

@Service
public class StudentService {
	@Autowired
	private StudentRepository studentRepository;

	public Student save(Student student) {
		Student savedStudent = studentRepository.save(student);
		return savedStudent;
	}
}
