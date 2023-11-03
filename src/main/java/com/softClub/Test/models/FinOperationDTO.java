package com.softClub.Test.models;

public class FinOperationDTO {
    private String description;
    private String sum;

    public FinOperationDTO() {
    }

    public FinOperationDTO(String description, String sum) {
        this.description = description;
        this.sum = sum;
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
