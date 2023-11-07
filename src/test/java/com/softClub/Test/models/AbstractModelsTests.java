package com.softClub.Test.models;

import com.softClub.Test.models.dto.FinOperationDTO;
import com.softClub.Test.models.dto.FinOperationDTOResponse;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Random;

public abstract class AbstractModelsTests {
    protected static Random rnd = new Random();
    protected static LocalDateTime now = LocalDateTime.now();

    public static Currency formCurrency() {
        BigDecimal decimal = new BigDecimal("123.456");
        return new CurrencyBuilder()
                .setVchCode("USD")
                .setVcode(1)
                .setVcurs(decimal)
                .setVname("TestName")
                .setVnom(decimal)
                .setVunitRate(2.5)
                .createCurrency();
    }

    public static FinOperationDTO formFinOperationDTO(LocalDateTime dateTime) {
        FinOperationDTO dto = new FinOperationDTO();
        dto.setSum("123.4567891");
        dto.setDescription("TestTestTest");
        dto.setDateTime(dateTime);
        return dto;
    }

    public static FinOperation formFinOperation(FinOperationDTO dto) {
        return new FinOperation(dto);
    }

    public static FinOperation formFinOperation() {
        FinOperation operation = new FinOperation();
        operation.setId(rnd.nextLong(100L));
        operation.setSum(new BigDecimal("12345.67890"));
        operation.setDescription("Test");
        operation.setDateTime(now);
        return operation;
    }

    public static FinOperationDTOResponse formFinOperationDTOResponse(FinOperation operation) {
        return new FinOperationDTOResponse(operation);
    }
}
