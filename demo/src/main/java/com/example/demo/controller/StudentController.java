package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dto.StudentDTO;
import com.example.demo.service.StudentService;

@Controller
public class StudentController {

	private static final Logger logger = LogManager.getLogger(StudentController.class);
	
   @Autowired
   private StudentService studentService;
   
   @GetMapping(value = {"/","/registration"})
   public String registration(Map<String, Object> model) {
	   logger.debug("Heelllo Debug");
	   logger.error("Heelllo Error");
	   logger.warn("Heellloo Warn");
	   logger.info("Heellloo Info");
	   logger.fatal("Heelloo fatal");
      model.put("student", new StudentDTO());
      return "student-add-update";
   }
   
   @PostMapping("/home")
   public String createStudent
         (@ModelAttribute("student") StudentDTO studentDto) {
	   logger.debug("Heelllo Debug");
	   logger.error("Heelllo Error");
	   logger.warn("Heellloo Warn");
	   logger.info("Heellloo Info");
	   logger.fatal("Heelloo fatal");
      studentService.createOrUpdateStudent(studentDto);
      return "redirect:/list";   
   }
   
   @GetMapping("/list")
   public String listOfStudent(Model model) {
      List<StudentDTO> studentList = studentService.getAllStudent();
      model.addAttribute("studentList", studentList);
      return "student-list";
   }
   @GetMapping("/search")
   public String search(Model model) {
      return "user-search";
   }
   
   @GetMapping("/byFirstName")
   public String byFirstName(Model model) {
      return "user-search-by-name";
   }
   
   @GetMapping("/searchUserByName")
   public String searchUserByName(Model model,@RequestParam("rollNo") Long rollNo) {
	   System.out.println("searchUserByName--method----"+rollNo);
	   List<StudentDTO> studentList = null;
	   studentList = studentService.getStudentByName(rollNo);
	   model.addAttribute("studentList", studentList);
	   return "student-list";
   }
   
   @GetMapping("/findByFirstName")
   public String findByFirstName(Model model,@RequestParam("rollNo") Long rollNo) {
	   System.out.println("searchUserByName--method----"+rollNo);
	   List<StudentDTO> studentList = null;
	   studentList = studentService.getStudentByName(rollNo);
	   model.addAttribute("studentList", studentList);
	   return "student-list";
   }
  
   
   @PostMapping("/delete")
   public String deleteStudent(@RequestParam("id") String id) {
      studentService.deleteStudent(Long.parseLong(id));
      return "redirect:/list";      
   }
   
   @GetMapping("/edit")
   public String editStudent(
         @RequestParam("id") String id, Map<String, Object> model) {
      StudentDTO studentDTO = studentService
            .editStudent(Long.parseLong(id));
      model.put("student", studentDTO);
      return "student-add-update";
   }
   
}
