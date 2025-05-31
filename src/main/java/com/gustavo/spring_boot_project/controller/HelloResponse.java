package com.gustavo.spring_boot_project.controller;

import java.time.LocalDateTime;

public class HelloResponse {
    private LocalDateTime date;
    private String status;

    public HelloResponse(LocalDateTime date, String status) {
        this.date = date;
        this.status = status;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String getStatus() {
        return status;
    }
}
