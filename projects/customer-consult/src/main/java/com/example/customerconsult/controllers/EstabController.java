package com.example.customerconsult.controllers;

import com.example.customerconsult.models.Estabelecimento;
import com.example.customerconsult.services.EstabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class EstabController {

    @Autowired
    private EstabService service;

    @GetMapping("/{cnpj}")
    public ResponseEntity<Estabelecimento> getByCnpj(@PathVariable String cnpj) {
        return new ResponseEntity<>(service.getByCnpj(cnpj), HttpStatus.OK);
    }
}
