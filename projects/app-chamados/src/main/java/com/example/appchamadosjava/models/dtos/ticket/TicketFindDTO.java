package com.example.appchamadosjava.models.dtos.ticket;

import com.example.appchamadosjava.models.dtos.user.UserDTO;
import com.example.appchamadosjava.models.enums.ProblemEnum;
import com.example.appchamadosjava.models.enums.SectorEnum;
import com.example.appchamadosjava.models.enums.StatusEnum;

import java.time.LocalDateTime;

public class TicketFindDTO {

    private Long id;
    private UserDTO user;
    private ProblemEnum problem;
    private SectorEnum sector;
    private StatusEnum status;
    private String description;
    private LocalDateTime initialDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public ProblemEnum getProblem() {
        return problem;
    }

    public void setProblem(ProblemEnum problem) {
        this.problem = problem;
    }

    public SectorEnum getSector() {
        return sector;
    }

    public void setSector(SectorEnum sector) {
        this.sector = sector;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getInitialDate() {
        return initialDate;
    }

    public void setInitialDate(LocalDateTime initialDate) {
        this.initialDate = initialDate;
    }
}
