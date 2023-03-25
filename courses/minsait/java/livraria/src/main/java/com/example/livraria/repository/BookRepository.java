package com.example.livraria.repository;

import com.example.livraria.entities.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Livro, Long> {
}
