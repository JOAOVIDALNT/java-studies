package com.example.appchamadosjava.services;

import com.example.appchamadosjava.dtos.TickerAddReviewDTO;
import com.example.appchamadosjava.dtos.TicketDTO;
import com.example.appchamadosjava.dtos.TicketFindDTO;
import com.example.appchamadosjava.dtos.TicketStatusUpdateDTO;
import com.example.appchamadosjava.enums.ProblemEnum;
import com.example.appchamadosjava.exceptions.ticketExeptions.InvalidDescriptionException;
import com.example.appchamadosjava.exceptions.ticketExeptions.InvalidNameException;
import com.example.appchamadosjava.exceptions.ticketExeptions.TicketNotFoundException;
import com.example.appchamadosjava.mapper.ModelMap;
import com.example.appchamadosjava.models.Ticket;
import com.example.appchamadosjava.repositories.TicketRepository;
import com.example.appchamadosjava.validation.ValidName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.validation.Valid;
import java.security.InvalidParameterException;
import java.util.List;

@Service
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    public TicketDTO create(@Valid TicketDTO ticketDTO) {
        Ticket entity = ModelMap.parseObject(ticketDTO, Ticket.class);
        TicketDTO dto = ModelMap.parseObject(ticketRepository.save(entity), TicketDTO.class);

        ValidName validName = new ValidName();
        validName.nameValidation(ticketDTO.getName());

        if(ticketDTO.getName().length() < 3) {
            throw new InvalidNameException();
        }
        if(ticketDTO.getDescription() == null || ticketDTO.getDescription().length() < 5) {
            throw new InvalidDescriptionException();
        }

        return dto;
    }

    public List<TicketFindDTO> findAll() {
        return ModelMap.parseListObjects(ticketRepository.findAll(), TicketFindDTO.class);
    }

    public TicketFindDTO findById(Long id) {
        Ticket entity = ticketRepository.findById(id).orElseThrow(() -> new TicketNotFoundException());

        return ModelMap.parseObject(entity, TicketFindDTO.class);
    }

    public void delete(Long id) {
        Ticket entity = ticketRepository.findById(id).orElseThrow(() -> new TicketNotFoundException());

        ticketRepository.delete(entity);
    }

    public TicketStatusUpdateDTO updateStatus(Long id, TicketStatusUpdateDTO ticketStatusUpdateDTO) {
        Ticket entity = ticketRepository.findById(id).orElseThrow(() -> new TicketNotFoundException());

        entity.setStatus(ticketStatusUpdateDTO.getStatus());

        TicketStatusUpdateDTO dto = ModelMap.parseObject(ticketRepository.save(entity), TicketStatusUpdateDTO.class);
        return dto;
    }

    public TickerAddReviewDTO addReview(Long id, TickerAddReviewDTO tickerAddReviewDTO) {
        Ticket entity = ticketRepository.findById(id).orElseThrow(() -> new TicketNotFoundException());

        entity.setReview(tickerAddReviewDTO.getReview());

        TickerAddReviewDTO dto = ModelMap.parseObject(ticketRepository.save(entity), TickerAddReviewDTO.class);
        return dto;
    }
}
