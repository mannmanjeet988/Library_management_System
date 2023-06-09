package com.example.Library_Management_system.service.impl;

import com.example.Library_Management_system.DTO.RequestDto.StudentRequestDto;
import com.example.Library_Management_system.DTO.RequestDto.UpdateStudentEmailIdRequestDto;
import com.example.Library_Management_system.DTO.ResponseDto.CardResponseDto;
import com.example.Library_Management_system.DTO.ResponseDto.StudentResponseDto;
import com.example.Library_Management_system.DTO.ResponseDto.UpdateStudentEmailIdResponseDto;

import com.example.Library_Management_system.entity.Card;
import com.example.Library_Management_system.entity.Student;
import com.example.Library_Management_system.enums.CardStatus;
import com.example.Library_Management_system.Exception.StudentNotFoundException;
import com.example.Library_Management_system.repository.StudentRepository;
import com.example.Library_Management_system.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
    public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

        @Override
        public String addStudent(StudentRequestDto studentRequestDto) {

            Student student = new Student();

            student.setName(studentRequestDto.getName());
            student.setAge(studentRequestDto.getAge());
            student.setDepartment(studentRequestDto.getDepartment());
            student.setEmailId(studentRequestDto.getEmailId());

            Card card = new Card();
            card.setCardStatus(CardStatus.ACTIVATED);
            card.setValidTill("2025-12-1");       // Date format: YY MM DD
            card.setStudent(student);

            student.setCard(card);
            studentRepository.save(student);
            return "Student Added sucessfully";

            // Without Dto : Add student in this manner
            //genrate a new card for the student
//            Card card = new Card();
//            card.setCardStatus(CardStatus.ACTIVATED);
//            card.setValidTill("2024-06-01");
//            card.setStudent(student);
//
//            //set card for the student
//            student.setCard(card);
//            studentRepository.save(student);
//            return "Student Added sucessfully";

        }

        public String deleteStudent(int id){
            studentRepository.deleteById(id);
            return "Student having id " + id+ " is deleted ";
        }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public StudentResponseDto getStudentById(int id) {
        Student student = studentRepository.findById(id).get();

        //prepare student response dto

        StudentResponseDto studentResponseDto = new StudentResponseDto();

        studentResponseDto.setId(student.getId());
        studentResponseDto.setName(student.getName());
        studentResponseDto.setAge(student.getAge());
        studentResponseDto.setDepartment(student.getDepartment());
        studentResponseDto.setEmailId(student.getEmailId());

        CardResponseDto cardResponseDto = new CardResponseDto();

        cardResponseDto.setId(student.getCard().getId());
        cardResponseDto.setIssueDate(student.getCard().getIssueDate());
        cardResponseDto.setUpdateOn(student.getCard().getUpdateOn());
        cardResponseDto.setCardStatus(student.getCard().getCardStatus());
        cardResponseDto.setValidTill(student.getCard().getValidTill());

        studentResponseDto.setCardResponseDto(cardResponseDto);

        return studentResponseDto;
    }

    public UpdateStudentEmailIdResponseDto updateEmailId(UpdateStudentEmailIdRequestDto updateStudentEmailIdRequestDto) throws StudentNotFoundException {
         try{
             Student student = studentRepository.findById(updateStudentEmailIdRequestDto.getId()).get();
             student.setEmailId(updateStudentEmailIdRequestDto.getEmailId());
             Student updatedStudent = studentRepository.save(student);

             // prepare student response DTO(conversion from entity to DTO)

             UpdateStudentEmailIdResponseDto updateStudentEmailIdResponseDto = new UpdateStudentEmailIdResponseDto();

             updateStudentEmailIdResponseDto.setName(updatedStudent.getName());
             updateStudentEmailIdResponseDto.setEmailId(updateStudentEmailIdRequestDto.getEmailId());

             return updateStudentEmailIdResponseDto;

         }
         catch(Exception e){
             throw new StudentNotFoundException("Invalid student Id");
         }
    }


}
