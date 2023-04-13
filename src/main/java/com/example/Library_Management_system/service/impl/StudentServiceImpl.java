package com.example.Library_Management_system.service.impl;

import com.example.Library_Management_system.entity.Card;
import com.example.Library_Management_system.entity.Student;
import com.example.Library_Management_system.enums.CardStatus;
import com.example.Library_Management_system.repository.StudentRepository;
import com.example.Library_Management_system.service.StudentService;
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
    }
