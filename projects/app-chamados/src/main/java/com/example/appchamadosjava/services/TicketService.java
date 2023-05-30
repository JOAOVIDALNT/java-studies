package com.example.appchamadosjava.services;

import com.example.appchamadosjava.models.enums.ProblemEnum;
import com.example.appchamadosjava.models.enums.SectorEnum;
import com.example.appchamadosjava.models.enums.StatusEnum;
import com.example.appchamadosjava.models.dtos.ticket.*;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface TicketService {
    public TicketDTO create(String email, TicketDTO ticketDTO);
    public List<TicketFindDTO> findAll();
    public TicketFindDTO findById(Long id);
    public List<TicketFindDTO> findByStatus(StatusEnum status);
    public List<TicketFindDTO> findBySector(SectorEnum sector);
    public List<TicketFindDTO> findByProblem(ProblemEnum problem);
    public void delete(Long id);
    public TicketStatusUpdateDTO updateStatus(Long id, TicketStatusUpdateDTO ticketStatusUpdateDTO);
    public TicketAddReviewDTO addReview(Long id, TicketAddReviewDTO ticketAddReviewDTO);
    public TicketReviewDTO getReview(Long id);
    public TicketProblemUpdateDTO updateProblem(Long id, TicketProblemUpdateDTO ticketProblemUpdateDTO);
    public List<TicketFindDTO> findTicketsByUser(String email);
}
