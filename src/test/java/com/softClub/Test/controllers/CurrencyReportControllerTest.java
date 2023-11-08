package com.softClub.Test.controllers;

import com.softClub.Test.models.dto.FinOperationDTO;
import com.softClub.Test.models.dto.ReportRequestDTO;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class CurrencyReportControllerTest extends AbstractControllersTest{

    @Test
    void formReport() throws Exception {
        FinOperationDTO dto = formFinOperationDTO(now);

        mockMvc.perform(post("/operations")
                .content(om.writeValueAsString(dto))
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON));

        mockMvc.perform(get("/operations/update"));

        ReportRequestDTO requestDTO = new ReportRequestDTO();
        requestDTO.setVchCode("USD");
        requestDTO.setStartDateTime(LocalDateTime.of(
                now.getYear(),
                now.getMonth(),
                now.getDayOfMonth(),
                0,
                0));
        requestDTO.setFinishDateTime(LocalDateTime.now());

        mockMvc.perform(post("/report")
                .content(om.writeValueAsString(requestDTO))
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"));
    }

    @Test
    void formReportEmpty() throws Exception {
        mockMvc.perform(get("/operations/update"));

        ReportRequestDTO requestDTO = new ReportRequestDTO();
        requestDTO.setVchCode("USD");
        requestDTO.setStartDateTime(LocalDateTime.now());
        requestDTO.setFinishDateTime(LocalDateTime.now());

        mockMvc.perform(post("/report")
                        .content(om.writeValueAsString(requestDTO))
                        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is(204));
    }

    @Test
    void formReportWrongCurrency() throws Exception {
        ReportRequestDTO requestDTO = new ReportRequestDTO();
        requestDTO.setVchCode("USDd");
        requestDTO.setStartDateTime(LocalDateTime.now());
        requestDTO.setFinishDateTime(LocalDateTime.now());

        mockMvc.perform(post("/report")
                        .content(om.writeValueAsString(requestDTO))
                        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is5xxServerError());
    }
}