package com.softClub.Test.controllers;

import com.softClub.Test.models.dto.FinOperationDTO;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class FinOperationControllerTest extends AbstractControllersTest {

    @Test
    void save() throws Exception {
        FinOperationDTO dto = formFinOperationDTO(now);

        mockMvc.perform(post("/operations")
                        .content(om.writeValueAsString(dto))
                        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.id", is(any(Integer.class))))
                .andExpect(jsonPath("$.dateTime").isNotEmpty())
                .andExpect(jsonPath("$.description", is(dto.getDescription())))
                .andExpect(jsonPath("$.sum", is(dto.getSum())));
    }

    @Test
    void saveError() throws Exception {
        mockMvc.perform(post("/operations"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    void getEntity() throws Exception {
        FinOperationDTO dto = formFinOperationDTO(now);

        mockMvc.perform(post("/operations")
                .content(om.writeValueAsString(dto))
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON));

        mockMvc.perform(get("/operations/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.dateTime").isNotEmpty())
                .andExpect(jsonPath("$.description", is(dto.getDescription())))
                .andExpect(jsonPath("$.sum", is(dto.getSum())));
    }

    @Test
    void getEntityError() throws Exception {
        mockMvc.perform(get("/operations/100"))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    void updateCurrencies() throws Exception {
        mockMvc.perform(get("/operations/update"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$", hasSize(43)));
    }
}