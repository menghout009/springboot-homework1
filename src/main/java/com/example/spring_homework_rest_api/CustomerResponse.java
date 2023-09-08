package com.example.spring_homework_rest_api;
import java.time.LocalDateTime;

public class CustomerResponse <T> {

    private LocalDateTime dateTime;
    private String status ;

    private String message;

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getPayload() {
        return payload;
    }

    public void setPayload(T payload) {
        this.payload = payload;
    }

    private T payload;

    public CustomerResponse(LocalDateTime dateTime, String status, String message, T payload) {
        this.dateTime = dateTime;
        this.status = status;
        this.message = message;
        this.payload = payload;
    }

    public CustomerResponse() {
    }
}
