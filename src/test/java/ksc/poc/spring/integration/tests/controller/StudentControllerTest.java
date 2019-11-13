package ksc.poc.spring.integration.tests.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.annotation.Description;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import ksc.poc.spring.integration.tests.SpringBootIntTestsApplication;
import ksc.poc.spring.integration.tests.entities.Student;

@SpringBootTest(classes = SpringBootIntTestsApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class StudentControllerTest {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	@Description("Given valid inputs, returns 201 and saved student response")
    @DisplayName("Given valid inputs, returns 201 and saved student response")
	public void testSave() 
    {
		// given / arrange
		Student request = Student.builder().firstName("Kaushlendra").lastName("Singh").build();
		
		// when /act
		ResponseEntity<Student> responseEntity = this.restTemplate.postForEntity(
								"http://localhost:" + port, 
								request, 
								Student.class);
		// then / assert
		assertNotNull(responseEntity,"Expected testSave response not null");
		assertEquals(HttpStatus.CREATED.value(), responseEntity.getStatusCodeValue());
		
		assertNotNull(responseEntity.getBody());
		Student response = responseEntity.getBody();
		assertEquals(response.getFirstName(), request.getFirstName(), "First name mismatched");
		assertEquals(response.getLastName(), request.getLastName(), "Last name mismatched");
    }

}
