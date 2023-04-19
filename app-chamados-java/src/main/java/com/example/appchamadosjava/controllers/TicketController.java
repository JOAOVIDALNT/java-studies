package com.example.appchamadosjava.controllers;

import com.example.appchamadosjava.dtos.TickerAddReviewDTO;
import com.example.appchamadosjava.dtos.TicketDTO;
import com.example.appchamadosjava.dtos.TicketFindDTO;
import com.example.appchamadosjava.dtos.TicketStatusUpdateDTO;
import com.example.appchamadosjava.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/tickets")
public class TicketController {
    @Autowired
    private TicketService ticketService;

    @PostMapping
    public ResponseEntity<TicketDTO> create(@Valid @RequestBody TicketDTO ticketDTO) {
        return new ResponseEntity<>(ticketService.create(ticketDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TicketFindDTO>> findAll() {
        return new ResponseEntity<>(ticketService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TicketFindDTO> findById(@PathVariable Long id) {
        return new ResponseEntity<>(ticketService.findById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        ticketService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/status/{id}")
    public ResponseEntity<TicketStatusUpdateDTO> updateStatus(@PathVariable Long id, TicketStatusUpdateDTO ticketStatusUpdateDTO) {
        return new ResponseEntity<>(ticketService.updateStatus(id, ticketStatusUpdateDTO), HttpStatus.OK);
    }

    @PutMapping("/review/{id}")
    public ResponseEntity<TickerAddReviewDTO> addReview(@PathVariable Long id, TickerAddReviewDTO tickerAddReviewDTO) {
        return new ResponseEntity<>(ticketService.addReview(id, tickerAddReviewDTO), HttpStatus.OK);
    }
}
