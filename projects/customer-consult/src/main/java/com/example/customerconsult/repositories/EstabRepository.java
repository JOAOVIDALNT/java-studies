package com.example.customerconsult.repositories;

import com.example.customerconsult.models.Estabelecimento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstabRepository extends JpaRepository<Estabelecimento, Long> {
    Estabelecimento findByCnpj(String cnpj);
}
