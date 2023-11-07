package com.softClub.Test.services;

import com.softClub.Test.models.Currency;
import com.softClub.Test.models.FinOperation;
import com.softClub.Test.models.dto.FinOperationDTOResponse;
import com.softClub.Test.models.dto.ReportDTO;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Service for calculating reports for specified currency VchCode.
 */
@Service
public class ReportService {
    private final CurrencyService currencyService;
    private final FinOperationService operationService;

    public ReportService(CurrencyService currencyService, FinOperationService operationService) {
        this.currencyService = currencyService;
        this.operationService = operationService;
    }

    /** Form ReportDTO class with all important information.
     * @param VchCode code of currency
     * @param dateTime begin point.
     * @param dateTime2 finish point.
     * @return Future object with ReportDTO class.
     */
    @Async
    public CompletableFuture<ReportDTO> formReport(String VchCode, LocalDateTime dateTime, LocalDateTime dateTime2) {
        Double vunitRate = getVunitRate(VchCode);
        List<FinOperation> operations = getOperations(dateTime, dateTime2);
        FinOperationDTOResponse[] dtoResponses = new FinOperationDTOResponse[operations.size()];

        ReportDTO report = new ReportDTO();
        report.setVchCode(VchCode);
        report.setVunitRate(vunitRate);
        report.setStartTime(dateTime);
        report.setFinishTime(dateTime2);
        report.setOperations(dtoResponses);

        for (int i = 0; i < operations.size(); i++) {
            FinOperation operation = operations.get(i);
            BigDecimal sum = operation.getSum();
            sum = sum.multiply(new BigDecimal(vunitRate));
            operation.setSum(sum);
            dtoResponses[i] = new FinOperationDTOResponse(operation);
        }
        return CompletableFuture.completedFuture(report);
    }

    /**
     * Get ratio for calculation.
     * @param VchCode code for searching.
     * @return Double representation of ratio.
     */
    private Double getVunitRate(String VchCode) {
        Currency result = currencyService.findByVchCode(VchCode);
        return result.getVunitRate();
    }

    /**
     * Get FinOperations for period of time.
     * Makes simple sanity check.
     * @param dateTime begin point.
     * @param dateTime2 finish point.
     * @return List of found FinOperations.
     */
    private List<FinOperation> getOperations(LocalDateTime dateTime, LocalDateTime dateTime2) {
        if (!dateTime.isBefore(dateTime2)) {
            LocalDateTime temp = dateTime2;
            dateTime2 = dateTime;
            dateTime = temp;
        }
        return operationService.findInPeriod(dateTime, dateTime2);
    }
}
