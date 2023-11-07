package com.softClub.Test.controllers;

import com.softClub.Test.models.dto.ReportDTO;
import com.softClub.Test.models.dto.ReportRequestDTO;
import com.softClub.Test.services.ReportService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

/**
 * Controller for reports.
 */
@RestController
@RequestMapping("/report")
public class CurrencyReportController {
    private final ReportService service;

    public CurrencyReportController(ReportService service) {
        this.service = service;
    }

    @Operation(summary = "Form report")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Report formed",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ReportDTO.class))}),
            @ApiResponse(responseCode = "204", description = "No operations found in period.",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error.",
                    content = @Content)})
    @PostMapping("")
    public ResponseEntity<?> formReport(@Valid @RequestBody ReportRequestDTO requestDTO) {
        CompletableFuture<ReportDTO> reportTask = service.formReport(
                requestDTO.getVchCode(),
                requestDTO.getStartDateTime(),
                requestDTO.getFinishDateTime()
        );
        try {
            ReportDTO report = reportTask.get(3000, MILLISECONDS);
            if (report.getOperations().length == 0) {
                return ResponseEntity.status(204).body("No results match.");
            }
            return ResponseEntity.ok(report);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Internal server error.");
        }
    }
}
