package com.example.appchamadosjava.dtos;

import com.example.appchamadosjava.enums.ProblemEnum;
import com.example.appchamadosjava.enums.SectorEnum;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class TicketDTO {

    private String name;
    private ProblemEnum problem;
    private SectorEnum sector;
    private String description;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
