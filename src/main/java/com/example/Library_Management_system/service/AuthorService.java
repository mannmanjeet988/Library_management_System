package com.example.Library_Management_system.service;

import com.example.Library_Management_system.DTO.ResponseDto.AuthorResponseDto;
import com.example.Library_Management_system.entity.Author;

public interface AuthorService {

    public String addAuthor(Author author);

    public AuthorResponseDto getByEmail(String email);
}
