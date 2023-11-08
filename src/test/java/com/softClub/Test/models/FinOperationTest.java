package com.softClub.Test.models;

import com.softClub.Test.models.dto.FinOperationDTO;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static com.softClub.Test.config.SpringConfig.PRECISION;
import static org.junit.jupiter.api.Assertions.*;

class FinOperationTest extends AbstractModelsTest {
    @Test
    void creationTest() {
        FinOperationDTO dto = formFinOperationDTO(now);
        FinOperation operation = formFinOperation(dto);

        assertEquals(new BigDecimal(dto.getSum()).setScale(PRECISION, RoundingMode.HALF_UP), operation.getSum());
        assertEquals(dto.getDescription(), operation.getDescription());
        assertEquals(now, operation.getDateTime());
    }

    @Test
    void creationTestError() {
        FinOperationDTO dto = formFinOperationDTO(now);
        dto.setSum(null);

        assertThrows(IllegalArgumentException.class, () -> formFinOperation(dto));
    }

    @Test
    void equalsTest(){
        FinOperationDTO dto = formFinOperationDTO(now);
        FinOperation operation1 = formFinOperation(dto);
        dto.setSum("444");
        FinOperation operation2 = formFinOperation(dto);

        assertNotEquals(operation2,operation1);
    }
}