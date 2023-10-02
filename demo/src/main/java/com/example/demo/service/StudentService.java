package com.example.demo.service;

import java.util.List;


import com.example.demo.dto.StudentDTO;

public interface StudentService {

   public void createOrUpdateStudent(StudentDTO empDTO);
   
   public List<StudentDTO> getAllStudent();
   
  public List<StudentDTO> getStudentByName(Long rollNo);
   
   public void deleteStudent(Long id);
   
   public StudentDTO editStudent(Long id);
   
}

