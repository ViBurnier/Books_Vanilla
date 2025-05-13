package com.books.api.controller.book;

import com.books.api.model.Books;
import com.books.api.util.ApiResponse;
import com.books.api.util.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Book;
import java.util.Map;

@RestController
@RequestMapping("/api/book")
@RequiredArgsConstructor
public class BookNewController {

    private final JwtUtil jwt;

    @PostMapping("/new")
    public ResponseEntity<?> newBook(@RequestBody Map<String, String> body){

       

        Books books = new Books();

        //apagar os sout depois

        System.out.println("Título recebido: " + body.get("title"));
        books.setTitle(body.get("title"));

        System.out.println("Autor recebido: " + body.get("author"));
        books.setAuthor(body.get("author"));

        System.out.println("Ano de publicação recebido: " + body.get("publicationYear"));
        books.setPublicationYear(Integer.parseInt(body.get("publicationYear")));

        System.out.println("Preço de aluguel por dia recebido: " + body.get("rentalPricePerDay"));
        books.setRentalPricePerDay(Float.parseFloat(body.get("rentalPricePerDay")));

        System.out.println("Disponibilidade recebida: " + body.get("available"));
        books.setAvailable(Integer.parseInt(body.get("available")));


        return ResponseEntity.ok(ApiResponse.success("201", "Livro adicionado com sucesso."));
    }
}
