package com.example.xmlgen.repositories;

import com.example.xmlgen.models.Nota;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotaRepository extends JpaRepository<Nota, Long> {
}
