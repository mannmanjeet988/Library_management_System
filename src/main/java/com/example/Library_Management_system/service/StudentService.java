package com.example.Library_Management_system.service;

import com.example.Library_Management_system.DTO.ResponseDto.StudentResponseDto;
import com.example.Library_Management_system.entity.Student;

public interface StudentService {

    public String addStudent(Student student);

    public StudentResponseDto getStudentById(int Id);
}
