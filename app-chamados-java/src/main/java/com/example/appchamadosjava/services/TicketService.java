package com.example.appchamadosjava.services;

import com.example.appchamadosjava.dtos.TicketDTO;
import com.example.appchamadosjava.mapper.ModelMap;
import com.example.appchamadosjava.models.Ticket;
import com.example.appchamadosjava.repositories.TicketRepository;
import jakarta.validation.Valid;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public List<TicketDTO> findAll() {
        return ModelMap.parseListObjects(ticketRepository.findAll(), TicketDTO.class);
    }
}
