package com.example.appchamadosjava.repositories;

import com.example.appchamadosjava.models.enums.ProblemEnum;
import com.example.appchamadosjava.models.enums.SectorEnum;
import com.example.appchamadosjava.models.enums.StatusEnum;
import com.example.appchamadosjava.models.entities.Ticket;
import com.example.appchamadosjava.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    List<Ticket> findAllByStatus(StatusEnum status);
    List<Ticket> findAllBySector(SectorEnum sector);
    List<Ticket> findAllByProblem(ProblemEnum problem);
    Ticket findTicketByUserAndStatusAndProblem(User user, StatusEnum status, ProblemEnum problem);
    List<Ticket> findTicketsByUser(User user);
}
