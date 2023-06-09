package com.example.Library_Management_system.DTO.RequestDto;

import com.example.Library_Management_system.enums.Department;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Adding student via Dto
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StudentRequestDto {
    private String name;

    private int age;

    private Department department;

    private String emailId;

}
