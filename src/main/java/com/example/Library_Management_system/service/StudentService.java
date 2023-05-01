package com.example.Library_Management_system.service;

import com.example.Library_Management_system.DTO.RequestDto.StudentRequestDto;
import com.example.Library_Management_system.DTO.RequestDto.UpdateStudentEmailIdRequestDto;
import com.example.Library_Management_system.DTO.ResponseDto.StudentResponseDto;
import com.example.Library_Management_system.DTO.ResponseDto.UpdateStudentEmailIdResponseDto;
import com.example.Library_Management_system.Exception.StudentNotFoundException;
import com.example.Library_Management_system.entity.Student;

import java.util.List;

public interface StudentService {


    //public String addStudent(Student student);

    public String addStudent(StudentRequestDto studentRequestDto);

    public StudentResponseDto getStudentById(int Id);

    public UpdateStudentEmailIdResponseDto updateEmailId(UpdateStudentEmailIdRequestDto updateStudentEmailIdRequestDto) throws StudentNotFoundException;
    public String deleteStudent(int id);

   public List<Student> getAllStudents();

}
