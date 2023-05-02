package com.example.appchamadosjava.dtos;

import com.example.appchamadosjava.enums.ProblemEnum;
import com.example.appchamadosjava.enums.SectorEnum;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class TicketDTO {
    @NotNull(message = "O nome é obrigatório")
    @Size(min = 5, message = "Nome muito curto")
    @Size(max = 50, message = "Nome muito longo")
    private String name;
    @NotNull(message = "Selecione o problema")
    private ProblemEnum problem;
    @NotNull(message = "Selecione o setor")
    private SectorEnum sector;
    @NotNull(message = "Descreva o problema")
    @Size(min = 10,  message = "Descrição muito curta")
    @Size(max = 255, message = "Descrição muito longa")
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
