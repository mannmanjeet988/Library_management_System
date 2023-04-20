package com.example.Library_Management_system.controller;

import com.example.Library_Management_system.DTO.ResponseDto.AuthorResponseDto;
import com.example.Library_Management_system.entity.Author;
import com.example.Library_Management_system.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @PostMapping("/add")
    public String addAuthor(@RequestBody Author author) {
       return authorService.addAuthor(author);
    }

    @GetMapping("/get_by_email")
    public AuthorResponseDto getAuthorByEmail(@RequestParam String email){
        return authorService.getByEmail(email);
    }

}


