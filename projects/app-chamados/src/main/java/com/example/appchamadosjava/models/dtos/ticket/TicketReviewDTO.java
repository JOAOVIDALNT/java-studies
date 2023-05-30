package com.example.appchamadosjava.models.dtos.ticket;

import com.example.appchamadosjava.models.enums.ProblemEnum;
import com.example.appchamadosjava.models.enums.SectorEnum;
import com.example.appchamadosjava.models.dtos.user.UserDTO;

import java.time.LocalDateTime;


public class TicketReviewDTO {

    private UserDTO user;
    private ProblemEnum problem;
    private SectorEnum sector;
    private String review;
    private LocalDateTime initialDate;
    private LocalDateTime finishDate;

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
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

    public LocalDateTime getInitialDate() {
        return initialDate;
    }

    public void setInitialDate(LocalDateTime initialDate) {
        this.initialDate = initialDate;
    }

    public LocalDateTime getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(LocalDateTime finishDate) {
        this.finishDate = finishDate;
    }
}
