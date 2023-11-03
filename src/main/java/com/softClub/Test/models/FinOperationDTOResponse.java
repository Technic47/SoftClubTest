package com.softClub.Test.models;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL) //Hide null fields
public class FinOperationDTOResponse {
    private Long id;
    private LocalDateTime dateTime;
    private String description;
    private String sum;

    public FinOperationDTOResponse(FinOperation operation) {
        this.id = operation.getId();
        this.dateTime = operation.getDateTime();
        this.description = operation.getDescription();
        this.sum = operation.getSum().toString();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSum() {
        return sum;
    }

    public void setSum(String sum) {
        this.sum = sum;
    }
}
