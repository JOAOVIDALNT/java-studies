package com.example.appchamadosjava.dtos;

import com.example.appchamadosjava.enums.ProblemEnum;
import com.example.appchamadosjava.enums.SectorEnum;
import com.example.appchamadosjava.enums.StatusEnum;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class TicketFindDTO {

    private Long id;
    private String name;
    private ProblemEnum problem;
    private SectorEnum sector;
    private StatusEnum status;
    private String description;
    private LocalDate initialDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public LocalDate getInitialDate() {
        return initialDate;
    }

    public void setInitialDate(LocalDate initialDate) {
        this.initialDate = initialDate;
    }
}
