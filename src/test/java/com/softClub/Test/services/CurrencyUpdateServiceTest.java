package com.softClub.Test.services;

import com.softClub.Test.client.models.generated.ValuteData;
import com.softClub.Test.models.Currency;
import com.softClub.Test.webclient.DailyCurrencyClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class CurrencyUpdateServiceTest {
    private DailyCurrencyClient dailyCurrencyClient;
    private CurrencyService currencyService;
    private CurrencyUpdateService updateService;

    @BeforeEach
    void setUp() {
        dailyCurrencyClient = mock(DailyCurrencyClient.class);
        currencyService = mock(CurrencyService.class);
        updateService = new CurrencyUpdateService(dailyCurrencyClient, currencyService);
    }

    @Test
    void updateTest() {
        List<ValuteData.ValuteCursOnDate> list = Arrays.asList(
                new ValuteData.ValuteCursOnDate(),
                new ValuteData.ValuteCursOnDate()
        );

        doReturn(list)
                .when(dailyCurrencyClient)
                .getCursOnDate(any(LocalDateTime.class));

        updateService.update1();
        updateService.update2();

        verify(dailyCurrencyClient, times(2)).getCursOnDate(any(LocalDateTime.class));
        verify(currencyService, times(list.size() * 2)).update(any(Currency.class));
    }

    @Test
    void updateAndGet() {
        List<ValuteData.ValuteCursOnDate> list = Arrays.asList(
                new ValuteData.ValuteCursOnDate(),
                new ValuteData.ValuteCursOnDate()
        );

        doReturn(list)
                .when(dailyCurrencyClient)
                .getCursOnDate(any(LocalDateTime.class));

        List<ValuteData.ValuteCursOnDate> valuteCursOnDates = updateService.updateAndGet();

        assertEquals(list, valuteCursOnDates);
        verify(dailyCurrencyClient, times(1)).getCursOnDate(any(LocalDateTime.class));
        verify(currencyService, times(list.size())).update(any(Currency.class));
    }
}