package com.example.appchamadosjava.services;

import com.example.appchamadosjava.dtos.*;
import com.example.appchamadosjava.enums.ProblemEnum;
import com.example.appchamadosjava.enums.SectorEnum;
import com.example.appchamadosjava.enums.StatusEnum;
import com.example.appchamadosjava.exceptions.handler1.InvalidParameterException;
import com.example.appchamadosjava.exceptions.handler1.TicketNotFoundException;
import com.example.appchamadosjava.exceptions.handler1.PermissionDeniedException;
import com.example.appchamadosjava.mapper.ModelMap;
import com.example.appchamadosjava.models.Ticket;
import com.example.appchamadosjava.repositories.TicketRepository;
import com.example.appchamadosjava.validation.ValidName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    public TicketDTO create(@Valid TicketDTO ticketDTO) {
        Ticket entity = ModelMap.parseObject(ticketDTO, Ticket.class);
        entity.setInitialDate(LocalDateTime.now());

        ValidName validName = new ValidName();
        boolean valid = validName.nameValidation(ticketDTO.getName());
        if(!valid) {
             throw new InvalidParameterException("Nome inválido");
        }else {
            TicketDTO dto = ModelMap.parseObject(ticketRepository.save(entity), TicketDTO.class);
            return dto;
        }
    }

    public List<TicketFindDTO> findAll() {
        return ModelMap.parseListObjects(ticketRepository.findAll(), TicketFindDTO.class);
    }

    public TicketFindDTO findById(Long id) {
        Ticket entity = ticketRepository.findById(id)
                .orElseThrow(() -> new TicketNotFoundException(id));

        return ModelMap.parseObject(entity, TicketFindDTO.class);
    }

    public List<TicketFindDTO> findByStatus(StatusEnum status) {
        List<Ticket> entity = ticketRepository.findAllByStatus(status);

        return ModelMap.parseListObjects(entity, TicketFindDTO.class);
    }

    public List<TicketFindDTO> findBySector(SectorEnum sector) {
        List<Ticket> entity = ticketRepository.findAllBySector(sector);

        return ModelMap.parseListObjects(entity, TicketFindDTO.class);
    }

    public List<TicketFindDTO> findByProblem(ProblemEnum problem) {
        List<Ticket> entity = ticketRepository.findAllByProblem(problem);

        return ModelMap.parseListObjects(entity, TicketFindDTO.class);
    }

    public void delete(Long id) {
        Ticket entity = ticketRepository.findById(id)
                .orElseThrow(() -> new TicketNotFoundException(id));

        ticketRepository.delete(entity);
    }

    public TicketStatusUpdateDTO updateStatus(Long id, TicketStatusUpdateDTO ticketStatusUpdateDTO) {
        Ticket entity = ticketRepository.findById(id)
                .orElseThrow(() -> new TicketNotFoundException(id));

        if(entity.getStatus() == StatusEnum.RESOLVIDO || entity.getStatus() == StatusEnum.CANCELADO) {
            throw new PermissionDeniedException("Impossível alterar status de chamados fechados");
        }

        if(ticketStatusUpdateDTO.getStatus() == StatusEnum.RESOLVIDO || ticketStatusUpdateDTO.getStatus() == StatusEnum.CANCELADO) {
            entity.setFinishDate(LocalDateTime.now());
        }
        entity.setStatus(ticketStatusUpdateDTO.getStatus());


        TicketStatusUpdateDTO dto = ModelMap.parseObject(ticketRepository.save(entity),
                TicketStatusUpdateDTO.class);
        return dto;
    }

    public TicketAddReviewDTO addReview(Long id, TicketAddReviewDTO ticketAddReviewDTO) {
        Ticket entity = ticketRepository.findById(id)
                .orElseThrow(() -> new TicketNotFoundException(id));

        if(entity.getStatus() != StatusEnum.RESOLVIDO) {
            throw new PermissionDeniedException("Só é possível avaliar chamados resolvidos");
        }

        entity.setReview(ticketAddReviewDTO.getReview());

        TicketAddReviewDTO dto = ModelMap.parseObject(ticketRepository.save(entity),
                TicketAddReviewDTO.class);
        return dto;
    }

    public TicketReviewDTO getReview(Long id) {
        Ticket entity = ticketRepository.findById(id)
                .orElseThrow(() -> new TicketNotFoundException(id));

        if(entity.getStatus() != StatusEnum.RESOLVIDO) {
            throw new PermissionDeniedException("O chamado ainda não foi resolvido");
        }
        if(entity.getReview() == null) {
            throw new PermissionDeniedException("O chamado ainda não foi avaliado");
        }

        return ModelMap.parseObject(entity, TicketReviewDTO.class);
    }

    public TicketProblemUpdateDTO updateProblem(Long id, TicketProblemUpdateDTO ticketProblemUpdateDTO) {
        Ticket entity = ticketRepository.findById(id)
                .orElseThrow(() -> new TicketNotFoundException(id));

        entity.setProblem(ticketProblemUpdateDTO.getProblem());

        TicketProblemUpdateDTO dto = ModelMap.parseObject(ticketRepository.save(entity), TicketProblemUpdateDTO.class);
        return dto;
    }


}
