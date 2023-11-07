package com.softClub.Test.models;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CurrencyTest extends AbstractModelsTests {
    @Test
    void creationTesT() {
        BigDecimal decimal = new BigDecimal("123.456");

        Currency currency = formCurrency();

        assertEquals("USD", currency.getVchCode());
        assertEquals(1, currency.getVcode());
        assertEquals(decimal, currency.getVcurs());
        assertEquals("TestName", currency.getVname());
        assertEquals(decimal, currency.getVnom());
        assertEquals(2.5, currency.getVunitRate());
    }


}