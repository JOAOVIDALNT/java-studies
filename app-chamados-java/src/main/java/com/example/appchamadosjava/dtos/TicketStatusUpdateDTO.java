package com.example.appchamadosjava.dtos;

import com.example.appchamadosjava.enums.StatusEnum;

public class TicketStatusUpdateDTO {

    private StatusEnum status;

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }
}
