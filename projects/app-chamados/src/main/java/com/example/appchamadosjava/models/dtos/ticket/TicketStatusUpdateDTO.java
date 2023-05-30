package com.example.appchamadosjava.models.dtos.ticket;

import com.example.appchamadosjava.models.enums.StatusEnum;

public class TicketStatusUpdateDTO {

    private StatusEnum status;

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }
}
