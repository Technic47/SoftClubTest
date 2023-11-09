package com.softClub.Test.services;

import com.softClub.Test.models.Currency;
import com.softClub.Test.models.FinOperation;
import com.softClub.Test.models.dto.FinOperationDTOResponse;
import com.softClub.Test.models.dto.ReportDTO;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

import static com.softClub.Test.config.SpringConfig.PRECISION;

/**
 * Service for calculating reports for specified currency`s VchCode.
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
     * @param periodStart begin point.
     * @param periodFinish finish point.
     * @return Future object with ReportDTO class.
     */
    @Async
    public CompletableFuture<ReportDTO> formReport(String VchCode, LocalDateTime periodStart, LocalDateTime periodFinish) {
        Double vunitRate = getVunitRate(VchCode);
        List<FinOperation> operations = getOperations(periodStart, periodFinish);
        FinOperationDTOResponse[] dtoResponses = new FinOperationDTOResponse[operations.size()];

        ReportDTO report = new ReportDTO();
        report.setVchCode(VchCode);
        report.setVunitRate(vunitRate);
        report.setStartTime(periodStart);
        report.setFinishTime(periodFinish);
        report.setOperations(dtoResponses);

        for (int i = 0; i < operations.size(); i++) {
            FinOperation operation = operations.get(i);
            BigDecimal sum = operation.getSum();
            sum = sum.divide(new BigDecimal(vunitRate),PRECISION, RoundingMode.HALF_UP);
            operation.setSum(sum);
            dtoResponses[i] = new FinOperationDTOResponse(operation);
        }

        AtomicInteger i = new AtomicInteger(0);
        operations.forEach(item -> {
            BigDecimal newSum = item.getSum().divide(new BigDecimal(vunitRate),PRECISION, RoundingMode.HALF_UP);
            dtoResponses[i.getAndIncrement()] = new FinOperationDTOResponse(item, newSum);
        });

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
     * @param periodStart begin point.
     * @param periodFinish finish point.
     * @return List of found FinOperations.
     */
    private List<FinOperation> getOperations(LocalDateTime periodStart, LocalDateTime periodFinish) {
        if (!periodStart.isBefore(periodFinish)) {
            LocalDateTime temp = periodFinish;
            periodFinish = periodStart;
            periodStart = temp;
        }
        return operationService.findInPeriod(periodStart, periodFinish);
    }
}
