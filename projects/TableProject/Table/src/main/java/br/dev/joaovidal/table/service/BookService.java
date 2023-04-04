package br.dev.joaovidal.table.service;

import br.dev.joaovidal.table.enums.Status;
import br.dev.joaovidal.table.exceptions.BookNotFoundException;
import br.dev.joaovidal.table.model.Book;
import br.dev.joaovidal.table.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository repository;

    public List<Book> getAll() {
        return repository.findAll();
    }

    public Book create(@Valid Book entity) {
        if(entity.getStatus() != Status.READ) {
            String content = "Book not finished yet";
            entity.setReview(content);
        }
        return repository.save(entity);
    }

    public Book getById(Long id) {
        Optional<Book> entity = repository.findById(id);

        return entity.orElseThrow(() -> new BookNotFoundException()); // por ser um optional tenho que lançar uma exceção caso não encontre
    }

    public Book update(Long id, Book entity) {
        Book book = repository.findById(id).get();

        if(entity.getStatus() != Status.READ) {
            String content = "Book not finished yet";
            entity.setReview(content);
        }

        book.setTitle(entity.getTitle());
        book.setAuthor(entity.getAuthor());
        book.setStatus(entity.getStatus());
        book.setReview(entity.getReview());

        return repository.save(book);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }



}
