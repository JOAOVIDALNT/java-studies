package br.dev.joaovidal.table.repository;

import br.dev.joaovidal.table.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
