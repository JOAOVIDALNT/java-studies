package com.example.appchamadosjava.repositories;

import com.example.appchamadosjava.models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
