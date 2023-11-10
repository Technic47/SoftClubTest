package com.softClub.Test.services;

import com.softClub.Test.models.AbstractModelsTest;
import com.softClub.Test.models.Currency;
import com.softClub.Test.models.FinOperation;
import com.softClub.Test.models.dto.FinOperationDTOResponse;
import com.softClub.Test.models.dto.ReportDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

class ReportServiceTest extends AbstractModelsTest {
    private CurrencyService currencyService;
    private FinOperationService operationService;
    private ReportService reportService;

    @BeforeEach
    void setUp() {
        currencyService = mock(CurrencyService.class);
        operationService = mock(FinOperationService.class);
        reportService = new ReportService(currencyService, operationService);
    }

    @Test
    void formReportTest() throws ExecutionException, InterruptedException {
        Currency currency = formCurrency();
        double rate = currency.getVunitRate();
        String code = currency.getVchCode();
        LocalDateTime time1 = LocalDateTime.now();
        LocalDateTime time2 = LocalDateTime.now();

        List<FinOperation> list = Arrays.asList(
                formFinOperation(),
                formFinOperation(),
                formFinOperation()
        );

        List<String> checkList = list.stream().map(operation -> operation.getSum().toString()).toList();

        doReturn(currency)
                .when(currencyService)
                .findByVchCode(code);
        doReturn(list)
                .when(operationService)
                .findInPeriod(time1, time2);

        ReportDTO reportDTO = reportService.formReport(code, time1, time2).get();

        FinOperationDTOResponse[] operations = reportDTO.getOperations();

        assertEquals(code, reportDTO.getVchCode());
        assertEquals(rate, reportDTO.getVunitRate());
        assertEquals(time1, reportDTO.getStartTime());
        assertEquals(time2, reportDTO.getFinishTime());
        assertEquals(checkList.size(), reportDTO.getOperations().length);

        for (int i = 0; i < operations.length; i++) {
            String s1 = checkList.get(i);
            String s2 = operations[i].getSum();
            assertNotEquals(s1, s2);
        }
    }
}