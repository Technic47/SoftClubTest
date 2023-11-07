package com.softClub.Test.models;

import com.softClub.Test.models.dto.FinOperationDTO;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class FinOperationTest extends AbstractModelsTests {
    @Test
    void creationTest() {
        FinOperationDTO dto = formFinOperationDTO(now);
        FinOperation operation = formFinOperation(dto);

        assertEquals(dto.getSum(), operation.getSum().toString());
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