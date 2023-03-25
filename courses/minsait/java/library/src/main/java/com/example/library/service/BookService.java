package com.example.library.service;

import com.example.library.model.Book;
import com.example.library.repository.BookRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository repository;

    public Book insertBook(Book book) {
        return repository.save(book);
    }

    public List<Book> findAll() {
        return repository.findAll();
    }

    public Book findById(Long id) {
        return repository.findById(id).get();
    }

    public Book updateBook(Long id, @Valid Book newBook) {
        Book entity = repository.findById(id).get();
        entity.setTitle(newBook.getTitle());
        entity.setYear(newBook.getYear());
        
        return repository.save(entity);
    }

    public void deleteBook(Long id) {
        repository.deleteById(id);
    }


}
