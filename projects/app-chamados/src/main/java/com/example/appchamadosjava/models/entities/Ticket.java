package com.example.appchamadosjava.models.entities;

import com.example.appchamadosjava.models.enums.ProblemEnum;
import com.example.appchamadosjava.models.enums.SectorEnum;
import com.example.appchamadosjava.models.enums.StatusEnum;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private User user;
    @Enumerated(EnumType.STRING)
    private ProblemEnum problem;
    @Enumerated(EnumType.STRING)
    private SectorEnum sector;
    @Enumerated(EnumType.STRING)
    private StatusEnum status = StatusEnum.PENDENTE;
    private String description;
    private String review;
    private LocalDateTime initialDate;
    private LocalDateTime finishDate;

    public Ticket() {
    }

    public Ticket(Long id, User user, ProblemEnum problem, SectorEnum sector, StatusEnum status, String description, String review, LocalDateTime initialDate, LocalDateTime finishDate) {
        this.id = id;
        this.user = user;
        this.problem = problem;
        this.sector = sector;
        this.status = status;
        this.description = description;
        this.review = review;
        this.initialDate = initialDate;
        this.finishDate = finishDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
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

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
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
