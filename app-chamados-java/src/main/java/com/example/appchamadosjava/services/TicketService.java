package com.example.appchamadosjava.services;

import com.example.appchamadosjava.dtos.TickerAddReviewDTO;
import com.example.appchamadosjava.dtos.TicketDTO;
import com.example.appchamadosjava.dtos.TicketFindDTO;
import com.example.appchamadosjava.dtos.TicketStatusUpdateDTO;
import com.example.appchamadosjava.mapper.ModelMap;
import com.example.appchamadosjava.models.Ticket;
import com.example.appchamadosjava.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.validation.Valid;
import java.util.List;

@Service
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    public TicketDTO create(@Valid TicketDTO ticketDTO) {
        Ticket entity = ModelMap.parseObject(ticketDTO, Ticket.class);
        TicketDTO dto = ModelMap.parseObject(ticketRepository.save(entity), TicketDTO.class);


        return dto;
    }

    public List<TicketFindDTO> findAll() {
        return ModelMap.parseListObjects(ticketRepository.findAll(), TicketFindDTO.class);
    }

    public TicketFindDTO findById(Long id) {
        Ticket entity = ticketRepository.findById(id).get();

        return ModelMap.parseObject(entity, TicketFindDTO.class);
    }

    public void delete(Long id) {
        Ticket entity = ticketRepository.findById(id).get();

        ticketRepository.delete(entity);
    }

    public TicketStatusUpdateDTO updateStatus(Long id, TicketStatusUpdateDTO ticketStatusUpdateDTO) {
        Ticket entity = ticketRepository.findById(id).get();

        entity.setStatus(ticketStatusUpdateDTO.getStatus());

        TicketStatusUpdateDTO dto = ModelMap.parseObject(ticketRepository.save(entity), TicketStatusUpdateDTO.class);
        return dto;
    }

    public TickerAddReviewDTO addReview(Long id, TickerAddReviewDTO tickerAddReviewDTO) {
        Ticket entity = ticketRepository.findById(id).get();

        entity.setReview(tickerAddReviewDTO.getReview());

        TickerAddReviewDTO dto = ModelMap.parseObject(ticketRepository.save(entity), TickerAddReviewDTO.class);
        return dto;
    }
}
