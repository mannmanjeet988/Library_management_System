package com.example.Library_Management_system.service.impl;

import com.example.Library_Management_system.DTO.RequestDto.IssueBookRequestDto;
import com.example.Library_Management_system.DTO.ResponseDto.IssueBookResponseDto;
import com.example.Library_Management_system.entity.Book;
import com.example.Library_Management_system.entity.Card;
import com.example.Library_Management_system.entity.Transaction;
import com.example.Library_Management_system.enums.Transaction_Status;
import com.example.Library_Management_system.repository.BookRepository;
import com.example.Library_Management_system.repository.CardRepository;
import com.example.Library_Management_system.repository.TransactionRepository;
import com.example.Library_Management_system.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TransactionServiceImpl implements TransactionService {

     @Autowired
    BookRepository bookRepository;

     @Autowired
    CardRepository cardRepository;

     @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    private JavaMailSender emailSender;


    @Override
    public IssueBookResponseDto issueBook(IssueBookRequestDto issueBookRequestDto) throws Exception {

        Transaction transaction = new Transaction();

        transaction.setTransactionNumber(String.valueOf(UUID.randomUUID()));
        transaction.setIssueOperation(true);

        Card card;
        try {
            card = cardRepository.findById(issueBookRequestDto.getCardId()).get();
        }
        catch(Exception e) {
            transaction.setTransaction_Status(Transaction_Status.FAILED);
            transactionRepository.save(transaction);
            throw new Exception("Invalid card Id !!");
        }

        transaction.setCard(card);

        Book book;
        try {
            book = bookRepository.findById(issueBookRequestDto.getBookId()).get();
        }
        catch(Exception e) {
            transaction.setTransaction_Status(Transaction_Status.FAILED);
            transactionRepository.save(transaction);
            throw new Exception("Invalid book Id !!");
        }
        transaction.setBook(book);

        if(book.isIssued() == true);

        transaction.setTransaction_Status(Transaction_Status.SUCCESS);
        book.setIssued(true);
        book.setCard(card);
        book.getTransactionList().add(transaction);

        card.getBooksIssued().add(book);
        card.getTransactionList().add(transaction);

        cardRepository.save(card);  // it will save all three information : card, book_id and transaction_id
                                      // as card is parent entity

        //prepare response dto

        IssueBookResponseDto issueBookResponseDto = new IssueBookResponseDto();

        issueBookResponseDto.setTransactionNumber(transaction.getTransactionNumber());
        issueBookResponseDto.setTransactionStatus(transaction.getTransaction_Status());
        issueBookResponseDto.setBookName(book.getTitle());

        String text = "Congrats! " + card.getStudent().getName() + " You have been issued the book " + book.getTitle();

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("acciobackend111@gmail.com");
        message.setTo(card.getStudent().getEmailId());
        message.setSubject("Issue Book");
        message.setText(text);
        emailSender.send(message);

        return issueBookResponseDto;

    }

}
