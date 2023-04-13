package com.example.Library_Management_system.entity;

import com.example.Library_Management_system.enums.Genre;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="book")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Book {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;
    @Enumerated(EnumType.STRING)
    private Genre genre;

    private int numberOfPages;
    private int price;
    @ManyToOne
    @JoinColumn
    Author author;

}
