package com.softClub.Test.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;

@Entity
public class FinOperation extends AbstractEntity {
    private LocalDateTime dateTime;
    private String description;
    private BigDecimal sum;

    public FinOperation() {
    }

    public FinOperation(Long id, LocalDateTime dateTime, String description, BigDecimal sum) {
        this.id = id;
        this.dateTime = dateTime;
        this.description = description;
        this.sum = sum;
    }

    public FinOperation(FinOperationDTO dto){
        this.dateTime = LocalDateTime.now();
        this.description = dto.getDescription();
        this.sum = new BigDecimal(dto.getSum());
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

    public BigDecimal getSum() {
        return sum;
    }

    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }
}
