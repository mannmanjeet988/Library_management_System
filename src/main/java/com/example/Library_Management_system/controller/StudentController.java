package com.example.Library_Management_system.controller;

import com.example.Library_Management_system.entity.Student;
import com.example.Library_Management_system.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;
    // we can make object of StudentServiceImpl class also instead of StudentService interface
@PostMapping("/add")
    public String addStudent(@RequestBody Student student){
       return studentService.addStudent(student);

    }

}
