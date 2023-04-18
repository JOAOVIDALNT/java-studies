package com.example.appchamadosjava.controllers;

import com.example.appchamadosjava.dtos.TicketDTO;
import com.example.appchamadosjava.services.TicketService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TicketController {
    @Autowired
    private TicketService ticketService;

    public ResponseEntity<TicketDTO> create(@RequestBody @Valid TicketDTO ticketDTO) {
        return new ResponseEntity<>(ticketService.create(ticketDTO), HttpStatus.CREATED);
    }

    public ResponseEntity<List<TicketDTO>> findAll() {
        return new ResponseEntity<>(ticketService.findAll(), HttpStatus.OK);
    }
}
