package com.example.livraria.controllers;

import com.example.livraria.entities.Book;
import com.example.livraria.services.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/livraria/livros")
public class BookController {

    private BookService service;

    @Autowired // é uma boa prática nas versões mais antigas do java anotar o construtor, facilita o mock
    public BookController(BookService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book registerBook(@Valid @RequestBody Book book) {
        return service.registerBook(book);
    }
}
