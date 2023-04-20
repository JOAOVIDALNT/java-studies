package com.example.appchamadosjava.controllers;

import com.example.appchamadosjava.dtos.*;
import com.example.appchamadosjava.enums.ProblemEnum;
import com.example.appchamadosjava.enums.SectorEnum;
import com.example.appchamadosjava.enums.StatusEnum;
import com.example.appchamadosjava.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/tickets")
@CrossOrigin("*")
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

    @GetMapping("/status/{status}")
    public ResponseEntity<List<TicketFindDTO>> findByStatus(@PathVariable StatusEnum status) {
        return new ResponseEntity<>(ticketService.findByStatus(status), HttpStatus.OK);
    }

    @GetMapping("/sector/{sector}")
    public ResponseEntity<List<TicketFindDTO>> findBySector(@PathVariable SectorEnum sector) {
        return new ResponseEntity<>(ticketService.findBySector(sector), HttpStatus.OK);
    }

    @GetMapping("/problem/{problem}")
    public ResponseEntity<List<TicketFindDTO>> findByProblem(@PathVariable ProblemEnum problem) {
        return new ResponseEntity<>(ticketService.findByProblem(problem), HttpStatus.OK);
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

    @PutMapping("/problem/{id}")
    public ResponseEntity<TicketProblemUpdateDTO> updateProblem(@PathVariable Long id, TicketProblemUpdateDTO ticketProblemUpdateDTO) {
        return new ResponseEntity<>(ticketService.updateProblem(id, ticketProblemUpdateDTO), HttpStatus.OK);
    }

    @PutMapping("/review/{id}")
    public ResponseEntity<TicketAddReviewDTO> addReview(@PathVariable Long id, TicketAddReviewDTO ticketAddReviewDTO) {
        return new ResponseEntity<>(ticketService.addReview(id, ticketAddReviewDTO), HttpStatus.OK);
    }

    @GetMapping("/review/{id}")
    public ResponseEntity<TicketReviewDTO> getReview(@PathVariable Long id) {
        return new ResponseEntity<>(ticketService.getReview(id), HttpStatus.OK);
    }
}
