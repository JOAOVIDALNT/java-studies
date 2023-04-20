package com.example.appchamadosjava.dtos;

import com.example.appchamadosjava.enums.ProblemEnum;

public class TicketProblemUpdateDTO {
    private ProblemEnum problem;

    public ProblemEnum getProblem() {
        return problem;
    }

    public void setProblem(ProblemEnum problem) {
        this.problem = problem;
    }
}
