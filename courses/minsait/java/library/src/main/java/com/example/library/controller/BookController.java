package com.example.library.controller;

import com.example.library.model.Book;
import com.example.library.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/library/books")
public class BookController {

    @Autowired
    private BookService service;


    // CREATE
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book insertBook(@Valid @RequestBody Book book) {
        return service.insertBook(book);
    }

    @PostMapping("/responseEntity")
    public ResponseEntity<Book> insertBookWithResponseEntity(@Valid @RequestBody Book book) {
        return new ResponseEntity<Book>(service.insertBook(book), HttpStatus.CREATED);
    } // Create method with ResponseEntity pattern


    // FIND ALL
    @GetMapping
    public List<Book> findAll() {
        return service.findAll();
    }

    @GetMapping("/responseEntity")
    public ResponseEntity<List<Book>> findAllWithResponseEntity() {
        return new ResponseEntity<List<Book>>(service.findAll(), HttpStatus.OK);
    } // FindAll method with ResponseEntity pattern



    // FIND BY ID
    @GetMapping("/{id}")
    public Book findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping("/response/{id}")
    public ResponseEntity<Book> findByIdWithResponseEntity(@PathVariable Long id) {
        return new ResponseEntity<Book>(service.findById(id), HttpStatus.OK);
    } // FindById method with ResponseEntity pattern



    // UPDATE
    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book newBook) {
        return service.updateBook(id, newBook);
    }





    // DELETE
    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        service.deleteBook(id);
    }


}
