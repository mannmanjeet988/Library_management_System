package com.example.Library_Management_system.DTO.ResponseDto;

import com.example.Library_Management_system.enums.CardStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CardResponseDto {

    private int id;

    private Date issueDate;

    private Date updateOn;         // it's datatype: data

    private CardStatus cardStatus;

    private String validTill;
}
