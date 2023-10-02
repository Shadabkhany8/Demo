package com.example.demo.repo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;

@SpringBootTest
public class StudentRepositoryTest {
	
	@Mock
	//@Autowired
	private StudentRepository studentRepository;

@Test
//@Disabled
void saveStudent() {
	Student student = new Student();
	student.setId((long) 100);
	student.setFirstName("Faruk");
	student.setLastName("Khan");
	student.setEmailId("Mic@gmail.com");
	studentRepository.save(student);

    }

//@Test
//@Disabled
//void getAllStudents() {
//    	Student student = new Student();
//    	student.setId((long) 100);
//    	student.setFirstName("Faruk");
//    	student.setLastName("Khan");
//    	student.setEmailId("Mic@gmail.com");
//	List<Student>std = studentRepository.getAllStudents();
	//System.out.println("Student"+std.toString());

   // }

@AfterEach
void tearDown() {
System.out.println("tearing down");
// studentRepository.deleteAll();
    }

@BeforeEach
void setUp() {
System.out.println("setting up");
    }
}

