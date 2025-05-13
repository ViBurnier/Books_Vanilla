package com.books.api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.awt.print.Book;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Books {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private int publicationYear;

    @Column(nullable = false)
    private String isbn;

    @Column(nullable = false)
    private int available; // Mostrar a quantidade de livros disponíveis para aluguel
    //private boolean available; // Indica se o livro está disponível para aluguel

    @Column(nullable = false)
    private float rentalPricePerDay; // Preço de aluguel por dia

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, columnDefinition = "VARCHAR(3) DEFAULT 'ON'")
    private Status status = Status.ON;

    public Books(){

    }

    public enum Status {
        ON,
        OFF
    }

}
