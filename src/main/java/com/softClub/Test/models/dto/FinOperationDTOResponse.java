package com.softClub.Test.models.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.softClub.Test.models.FinOperation;

import java.math.MathContext;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * DTO for sending info to clients.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FinOperationDTOResponse {
    private Long id;
    private LocalDateTime dateTime;
    private String description;
    private String sum;

    public FinOperationDTOResponse(FinOperation operation) {
        this.id = operation.getId();
        this.dateTime = operation.getDateTime();
        this.description = operation.getDescription();
        this.sum = operation.getSum().stripTrailingZeros().toString();
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FinOperationDTOResponse)) return false;
        FinOperationDTOResponse that = (FinOperationDTOResponse) o;
        return Objects.equals(id, that.id) && Objects.equals(dateTime, that.dateTime) && Objects.equals(description, that.description) && Objects.equals(sum, that.sum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dateTime, description, sum);
    }
}
