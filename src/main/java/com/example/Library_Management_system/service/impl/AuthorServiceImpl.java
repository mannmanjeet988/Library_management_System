package com.example.Library_Management_system.service.impl;

import com.example.Library_Management_system.entity.Author;
import com.example.Library_Management_system.repository.AuthorRepository;
import com.example.Library_Management_system.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    @Override
    public String addAuthor(Author author) {
        authorRepository.save(author);
        return "Author added";
    }
}
