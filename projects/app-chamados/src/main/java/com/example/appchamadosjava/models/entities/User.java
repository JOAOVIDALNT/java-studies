package com.example.appchamadosjava.models.entities;

import javax.persistence.*;
import java.util.List;
@Entity(name = "employee") // O nome user é reservado no db, por isso a definição de employee
public class User {
    @Id
    private String email;
    private String name;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Ticket> tickets;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }
}
