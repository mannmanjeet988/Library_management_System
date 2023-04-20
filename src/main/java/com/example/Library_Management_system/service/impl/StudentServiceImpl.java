package com.example.Library_Management_system.service.impl;

import com.example.Library_Management_system.DTO.ResponseDto.CardResponseDto;
import com.example.Library_Management_system.DTO.ResponseDto.StudentResponseDto;
import com.example.Library_Management_system.entity.Card;
import com.example.Library_Management_system.entity.Student;
import com.example.Library_Management_system.enums.CardStatus;
import com.example.Library_Management_system.repository.StudentRepository;
import com.example.Library_Management_system.service.StudentService;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
    public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

        @Override
        public String addStudent(Student student) {

            //genrate a new card for the student
            Card card = new Card();
            card.setCardStatus(CardStatus.ACTIVATED);
            card.setValidTill("2024-06-01");
            card.setStudent(student);

            //set card for the student
            student.setCard(card);
            studentRepository.save(student);
            return "Student Added sucessfully";

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
        studentResponseDto.setMobNo(student.getMobNo());

        CardResponseDto cardResponseDto = new CardResponseDto();

        cardResponseDto.setId(student.getCard().getId());
        cardResponseDto.setIssueDate(student.getCard().getIssueDate());
        cardResponseDto.setUpdateOn(student.getCard().getUpdateOn());
        cardResponseDto.setCardStatus(student.getCard().getCardStatus());
        cardResponseDto.setValidTill(student.getCard().getValidTill());

        studentResponseDto.setCardResponseDto(cardResponseDto);

        return studentResponseDto;


    }
}
