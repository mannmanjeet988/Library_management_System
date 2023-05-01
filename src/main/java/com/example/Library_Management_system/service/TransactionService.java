package com.example.Library_Management_system.service;

import com.example.Library_Management_system.DTO.RequestDto.IssueBookRequestDto;
import com.example.Library_Management_system.DTO.ResponseDto.IssueBookResponseDto;

public interface TransactionService {

    public IssueBookResponseDto issueBook(IssueBookRequestDto issueBookRequestDto) throws Exception;
}
