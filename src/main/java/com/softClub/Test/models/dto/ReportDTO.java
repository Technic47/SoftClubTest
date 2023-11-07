package com.softClub.Test.models.dto;

import java.time.LocalDateTime;

/**
 * DTO to sent main info about operations from period of time.
 * Contains currency code, rate, time limits and array of operations.
 */
public class ReportDTO {
    private String vchCode;
    private Double vunitRate;
    private LocalDateTime startTime;
    private LocalDateTime finishTime;
    private FinOperationDTOResponse[] operations;

    public String getVchCode() {
        return vchCode;
    }

    public void setVchCode(String vchCode) {
        this.vchCode = vchCode;
    }

    public Double getVunitRate() {
        return vunitRate;
    }

    public void setVunitRate(Double vunitRate) {
        this.vunitRate = vunitRate;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(LocalDateTime finishTime) {
        this.finishTime = finishTime;
    }

    public FinOperationDTOResponse[] getOperations() {
        return operations;
    }

    public void setOperations(FinOperationDTOResponse[] operations) {
        this.operations = operations;
    }
}
