package com.example.Library_Management_system.controller;

import com.example.Library_Management_system.DTO.RequestDto.StudentRequestDto;
import com.example.Library_Management_system.DTO.RequestDto.UpdateStudentEmailIdRequestDto;
import com.example.Library_Management_system.DTO.ResponseDto.StudentResponseDto;
import com.example.Library_Management_system.DTO.ResponseDto.UpdateStudentEmailIdResponseDto;
import com.example.Library_Management_system.Exception.StudentNotFoundException;
import com.example.Library_Management_system.entity.Student;
import com.example.Library_Management_system.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;
    // we can make object of StudentServiceImpl class also instead of StudentService interface

//     @PostMapping("/add")
//    public String addStudent(@RequestBody Student student){
//       return studentService.addStudent(student);
//    }

    @PostMapping("/add")
    public String addStudent(@RequestBody StudentRequestDto studentRequestDTO){
     return studentService.addStudent(studentRequestDTO);
    }

    @GetMapping("/get_student")
    public StudentResponseDto getStudentById(@RequestParam int id){
    return studentService.getStudentById(id);
    }

    @PutMapping("/update_mobile")
    public UpdateStudentEmailIdResponseDto updateMobNo(@RequestBody UpdateStudentEmailIdRequestDto updateStudentEmailIdRequestDto) throws StudentNotFoundException{
    return studentService.updateEmailId(updateStudentEmailIdRequestDto);
    }

    // Homework(12-04-2023)
    // Delete  a student by Id
    // Update the student by id
    // find a student by id
    // find all students

    @DeleteMapping("/delete")
    public String deleteStudent(@RequestParam("id") int id){
        studentService.deleteStudent(id);
        return "Student having id " + id+ " is deleted ";
    }

    @GetMapping("/getAllStudents")
    public List<Student> getAllStudents(){
        List<Student> allStudents = studentService.getAllStudents();
        return allStudents;
    }
}
