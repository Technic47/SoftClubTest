package com.softClub.Test.controllers;

import com.softClub.Test.client.models.generated.ValuteData;
import com.softClub.Test.models.FinOperation;
import com.softClub.Test.models.dto.FinOperationDTO;
import com.softClub.Test.models.dto.FinOperationDTOResponse;
import com.softClub.Test.webclient.DailyCurrencyClient;
import com.softClub.Test.services.FinOperationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Controller for FinOperation workaround.
 */
@RestController
@RequestMapping("/operations")
public class FinOperationController {
    private final FinOperationService service;
    private final DailyCurrencyClient client;

    public FinOperationController(FinOperationService service, DailyCurrencyClient client) {
        this.service = service;
        this.client = client;
    }

    @Operation(summary = "Save new operation")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Entity is saved",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = FinOperationDTOResponse.class))}),
            @ApiResponse(responseCode = "500", description = "Internal server error.",
                    content = @Content)})
    @PostMapping()
    public ResponseEntity<FinOperationDTOResponse> save(@RequestBody FinOperationDTO dto) {
        FinOperation saved = service.save(new FinOperation(dto));
        return ResponseEntity.ok(new FinOperationDTOResponse(saved));
    }

    @Operation(summary = "Get entity by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Entity is found",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = FinOperationDTOResponse.class))}),
            @ApiResponse(responseCode = "404", description = "Entity not found",
                    content = @Content)})
    @GetMapping("/{id}")
    public ResponseEntity<FinOperationDTOResponse> get(@PathVariable Long id) {
        FinOperation found = service.getById(id);
        return ResponseEntity.ok(new FinOperationDTOResponse(found));
    }

    @Operation(summary = "Update currencies now")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Updated",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ValuteData.ValuteCursOnDate.class))}),
            @ApiResponse(responseCode = "500", description = "Internal server error.",
                    content = @Content)})
    @GetMapping("/update")
    public ResponseEntity<?> updateCurrencies() {
        List<ValuteData.ValuteCursOnDate> response = client.getCursOnDate(LocalDateTime.now());

        return ResponseEntity.ok(response);
    }
}
