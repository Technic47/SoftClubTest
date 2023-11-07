package com.softClub.Test.models;

import com.softClub.Test.models.dto.FinOperationDTO;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Entity for incoming operations storing.
 */
@Entity
public class FinOperation extends AbstractEntity {
    private LocalDateTime dateTime;
    private String description;
    private BigDecimal sum;

    public FinOperation() {
    }

    public FinOperation(FinOperationDTO dto) {
        LocalDateTime dtoDateTime = dto.getDateTime();
        this.dateTime = Objects.requireNonNullElseGet(dtoDateTime, LocalDateTime::now);
        this.description = dto.getDescription();
        if (dto.getSum() == null) {
            throw new IllegalArgumentException("Argument 'sum' is null!");
        }
        this.sum = new BigDecimal(dto.getSum()).setScale(7, RoundingMode.HALF_UP);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FinOperation)) return false;
        if (!super.equals(o)) return false;
        FinOperation operation = (FinOperation) o;
        return Objects.equals(dateTime, operation.dateTime) && Objects.equals(description, operation.description) && Objects.equals(sum, operation.sum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), dateTime, description, sum);
    }
}
