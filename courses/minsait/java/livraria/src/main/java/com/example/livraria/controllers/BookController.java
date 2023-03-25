package com.example.livraria.controllers;

import com.example.livraria.entities.Livro;
import com.example.livraria.services.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/livraria/livros")
public class BookController {

    @Autowired
    private BookService service;


    @PostMapping("register")
    @ResponseStatus(HttpStatus.CREATED)
    public Livro registerBook(@Valid @RequestBody Livro livro) {
        return this.service.registerBook(livro);
    }
}
