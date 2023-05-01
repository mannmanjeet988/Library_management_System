package com.example.Library_Management_system.DTO.ResponseDto;


import com.example.Library_Management_system.enums.Department;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StudentResponseDto {

    private int id;

    private String name;

    private int age;

    private Department department;

    private String emailId;

    CardResponseDto cardResponseDto;


}
