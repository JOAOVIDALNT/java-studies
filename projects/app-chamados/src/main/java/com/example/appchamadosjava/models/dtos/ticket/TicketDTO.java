package com.example.appchamadosjava.models.dtos.ticket;

import com.example.appchamadosjava.models.enums.ProblemEnum;
import com.example.appchamadosjava.models.enums.SectorEnum;


public class TicketDTO {
    private ProblemEnum problem;
    private SectorEnum sector;
//    @NotNull(message = "Descreva o problema")
//    @Size(min = 10, max = 255, message = "A descrição deve ter entre {min} e {max} caracteres")
    private String description;


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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
