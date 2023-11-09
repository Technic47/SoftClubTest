package com.softClub.Test.models.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

/**
 * DTO for forming ReportDTO.
 * Contains main field for ReportDTO - currency code and time limits.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReportRequestDTO {
    @NotBlank(message = "Поле не должно быть пустым!")
    @Size(min = 1, max = 4)
    private String vchCode;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime periodStart;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime periodFinish;

    public String getVchCode() {
        return vchCode;
    }

    public void setVchCode(String vchCode) {
        this.vchCode = vchCode;
    }

    public LocalDateTime getPeriodStart() {
        return periodStart;
    }

    public void setPeriodStart(LocalDateTime periodStart) {
        this.periodStart = periodStart;
    }

    public LocalDateTime getPeriodFinish() {
        return periodFinish;
    }

    public void setPeriodFinish(LocalDateTime periodFinish) {
        this.periodFinish = periodFinish;
    }
}
