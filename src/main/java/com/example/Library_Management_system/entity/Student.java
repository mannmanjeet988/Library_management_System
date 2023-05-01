package com.example.Library_Management_system.entity;

import com.example.Library_Management_system.enums.Department;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="student")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private int age;


    @Enumerated(EnumType.STRING)
    private Department department;

    private String emailId;


    @OneToOne(mappedBy = "student",cascade=CascadeType.ALL)
    Card card;
}
