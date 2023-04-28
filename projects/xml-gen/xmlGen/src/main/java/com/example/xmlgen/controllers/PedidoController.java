package com.example.xmlgen.controllers;

import com.example.xmlgen.models.file.Pedido;
import com.example.xmlgen.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/xmlGenerate")
public class PedidoController {

    @Autowired
    private PedidoService service;

    @PostMapping
    public String create(@RequestBody Pedido pedido) {
        return service.create(pedido);
    }

}
