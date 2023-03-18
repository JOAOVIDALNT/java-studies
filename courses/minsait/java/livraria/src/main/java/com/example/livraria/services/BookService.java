package com.example.livraria.services;

import com.example.livraria.entities.Book;
import com.example.livraria.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepository repository;

    public Book registerBook(Book book) {
        return repository.save(book);
    }
}
