package com.example.appchamadosjava.services;

import com.example.appchamadosjava.models.enums.ProblemEnum;
import com.example.appchamadosjava.models.enums.SectorEnum;
import com.example.appchamadosjava.models.enums.StatusEnum;
import com.example.appchamadosjava.exceptions.InvalidParameterException;
import com.example.appchamadosjava.exceptions.TicketNotFoundException;
import com.example.appchamadosjava.exceptions.PermissionDeniedException;
import com.example.appchamadosjava.exceptions.UserNotFoundException;
import com.example.appchamadosjava.mappers.ModelMap;
import com.example.appchamadosjava.models.dtos.ticket.*;
import com.example.appchamadosjava.models.entities.Ticket;
import com.example.appchamadosjava.models.entities.User;
import com.example.appchamadosjava.repositories.TicketRepository;
import com.example.appchamadosjava.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private UserRepository userRepository;


    public TicketDTO create(String email, TicketDTO ticketDTO) {

        User user = userRepository.findByEmail(email);
        if(user == null) {
            throw new UserNotFoundException(email);
        }
        Ticket finder = ticketRepository.findTicketByUserAndStatusAndProblem(user,
                StatusEnum.PENDENTE, ticketDTO.getProblem());
        if(finder != null) {
            throw new PermissionDeniedException("Você já tem um chamado aberto");
        }

        Ticket entity = ModelMap.parseObject(ticketDTO, Ticket.class);
        entity.setInitialDate(LocalDateTime.now());
        entity.setUser(user);

        user.addTicket(entity);

        TicketDTO dto = ModelMap.parseObject(ticketRepository.save(entity), TicketDTO.class);
        return dto;
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
        } else if(ticketAddReviewDTO.getReview() == "") {
            throw new InvalidParameterException("Revise o chamado");
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

    public List<TicketFindDTO> findTicketsByUser(String email) {
        User user = userRepository.findByEmail(email);
        if(user == null) {
            throw new UserNotFoundException(email);
        }

        List<Ticket> tickets = ticketRepository.findTicketsByUser(user);
        return ModelMap.parseListObjects(tickets, TicketFindDTO.class);
    }



}
