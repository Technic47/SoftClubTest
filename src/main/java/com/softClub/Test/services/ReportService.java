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
import java.util.stream.Collectors;

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

    /**
     * Form ReportDTO class with all important information.
     *
     * @param VchCode      code of currency
     * @param periodStart  begin point.
     * @param periodFinish finish point.
     * @return Future object with ReportDTO class.
     */
    @Async
    public CompletableFuture<ReportDTO> formReport(String VchCode, LocalDateTime periodStart, LocalDateTime periodFinish) {
        double vunitRate = getVunitRate(VchCode);
        List<FinOperation> operationsToReCalc = getOperations(periodStart, periodFinish);

        FinOperationDTOResponse[] dtoResponses = operationsToReCalc.stream()
                .peek(operation -> {
                    BigDecimal newSum = operation.getSum().divide(new BigDecimal(vunitRate), PRECISION, RoundingMode.HALF_UP);
                    operation.setSum(newSum);
                }).map(FinOperationDTOResponse::new)
                .toArray(FinOperationDTOResponse[]::new);

        ReportDTO report = new ReportDTO();
        report.setVchCode(VchCode);
        report.setVunitRate(vunitRate);
        report.setStartTime(periodStart);
        report.setFinishTime(periodFinish);
        report.setOperations(dtoResponses);

        return CompletableFuture.completedFuture(report);
    }

    /**
     * Get ratio for calculation.
     *
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
     *
     * @param periodStart  begin point.
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
