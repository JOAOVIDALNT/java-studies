package com.example.livraria.services;

import com.example.livraria.entities.Livro;
import com.example.livraria.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {


    @Autowired
    private BookRepository repository;


    public Livro registerBook(Livro livro) {
        return this.repository.save(livro);
    }
}
