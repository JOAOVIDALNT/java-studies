package com.example.appchamadosjava.repositories;

import com.example.appchamadosjava.enums.ProblemEnum;
import com.example.appchamadosjava.enums.SectorEnum;
import com.example.appchamadosjava.enums.StatusEnum;
import com.example.appchamadosjava.models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    List<Ticket> findAllByStatus(StatusEnum status);
    List<Ticket> findAllBySector(SectorEnum sector);
    List<Ticket> findAllByProblem(ProblemEnum problem);
}
