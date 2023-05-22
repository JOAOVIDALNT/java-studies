package com.example.customerconsult.services;

import com.example.customerconsult.models.Estabelecimento;
import com.example.customerconsult.repositories.EstabRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstabService {

    @Autowired
    private EstabRepository repository;

    public Estabelecimento getByCnpj(String cnpj) {
        Estabelecimento entity = repository.findByCnpj(cnpj);

        return entity;
    }
}
