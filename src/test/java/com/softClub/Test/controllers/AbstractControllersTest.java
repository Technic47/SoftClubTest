package com.softClub.Test.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.softClub.Test.models.AbstractModelsTest;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public abstract class AbstractControllersTest extends AbstractModelsTest {
    protected static final ObjectMapper om = new ObjectMapper();
    @Autowired
    protected MockMvc mockMvc;

    @BeforeAll
    static void setUp(){
        om.findAndRegisterModules();
    }
}
