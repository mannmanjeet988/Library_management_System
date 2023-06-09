package com.example.Library_Management_system.DTO.ResponseDto;

import com.example.Library_Management_system.enums.Transaction_Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class IssueBookResponseDto {

    private String transactionNumber;

    private Transaction_Status transactionStatus;

    private String bookName;
}
