package com.example.appchamadosjava.dtos;

import com.example.appchamadosjava.enums.ProblemEnum;
import com.example.appchamadosjava.enums.SectorEnum;

import java.time.LocalDate;
import java.util.Date;

public class TicketReviewDTO {

    private String name;
    private ProblemEnum problem;
    private SectorEnum sector;
    private String review;
    private LocalDate initialDate;
    private LocalDate finishDate;

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
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

    public LocalDate getInitialDate() {
        return initialDate;
    }

    public void setInitialDate(LocalDate initialDate) {
        this.initialDate = initialDate;
    }

    public LocalDate getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(LocalDate finishDate) {
        this.finishDate = finishDate;
    }
}
