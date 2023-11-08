package com.softClub.Test.services;

import com.softClub.Test.exceptionhendlers.ResourceNotFoundException;
import com.softClub.Test.models.AbstractModelsTest;
import com.softClub.Test.models.Currency;
import com.softClub.Test.repositories.CurrencyRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class CurrencyServiceTest extends AbstractModelsTest {
    private CurrencyRepository repository;
    private CurrencyService service;

    @BeforeEach
    void setUp() {
        repository = mock(CurrencyRepository.class);
        service = new CurrencyService(repository);
    }

    @Test
    void findByVchCodeTest() {
        Currency currency = formCurrency();
        String code = currency.getVchCode();

        doReturn(Optional.of(currency))
                .when(repository)
                .findByVchCode(code);

        Currency byVchCode = service.findByVchCode(code);

        assertEquals(code, byVchCode.getVchCode());
        verify(repository, times(1)).findByVchCode(code);
    }

    @Test
    void findByVchCodeTestError() {
        String code = "qwe";

        doReturn(Optional.empty())
                .when(repository)
                .findByVchCode(code);
        assertThrows(ResourceNotFoundException.class, () -> service.findByVchCode(code));
        verify(repository, times(1)).findByVchCode(code);
    }

    @Test
    void updateTest() {
        Currency currency = formCurrency();
        Currency currencyNew = formCurrency();
        String code = currency.getVchCode();

        currencyNew.setVunitRate(5.0);
        currencyNew.setVnom(new BigDecimal(123));
        currencyNew.setVname("test");
        currencyNew.setVcurs(new BigDecimal(123));
        currencyNew.setVcode(333);

        doReturn(Optional.of(currency))
                .when(repository)
                .findByVchCode(code);

        doReturn(currency)
                .when(repository)
                .save(any(Currency.class));

        Currency updated = service.update(currencyNew);

        assertEquals(updated, currencyNew);
        verify(repository, times(1)).save(currency);
    }

    @Test
    void updateTestNew() {
        Currency currencyNew = formCurrency();
        String code = currencyNew.getVchCode();

        currencyNew.setVunitRate(5.0);
        currencyNew.setVnom(new BigDecimal(123));
        currencyNew.setVname("test");
        currencyNew.setVcurs(new BigDecimal(123));
        currencyNew.setVcode(333);

        doReturn(Optional.empty())
                .when(repository)
                .findByVchCode(code);

        doReturn(currencyNew)
                .when(repository)
                .save(any(Currency.class));

        Currency updated = service.update(currencyNew);

        assertEquals(updated, currencyNew);
        verify(repository, times(1)).save(currencyNew);
    }
}