package com.example.appchamadosjava.models.dtos.ticket;

import com.example.appchamadosjava.models.enums.ProblemEnum;

public class TicketProblemUpdateDTO {
    private ProblemEnum problem;

    public ProblemEnum getProblem() {
        return problem;
    }

    public void setProblem(ProblemEnum problem) {
        this.problem = problem;
    }
}
