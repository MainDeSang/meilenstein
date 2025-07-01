package com.example.meilenstein;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class PersonControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testControllerPerson() throws Exception {
        mockMvc.perform(get("/person"))
                .andExpect(status().isOk());

    }

    @Test
    public void testEntriesGetIsAviableAndReturnData() throws Exception {
        mockMvc.perform(get("/person"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Meilenstein"))
                .andExpect(jsonPath("$", hasSize(3)))

                .andExpect(jsonPath("$[0].firstName").isNotEmpty())
                .andExpect(jsonPath("$[1].lastName").isNotEmpty())
                .andExpect(jsonPath("$[2].dateOfBirth").isNotEmpty())

                .andExpect(jsonPath("$[0].firstName", is("Max")))
                .andExpect(jsonPath("$[1].lastName", is("Mustermann")))
                .andExpect(jsonPath("$[2].dateOfBirth", is(1997 - 06 - 23)))

                .andExpect(jsonPath("$[*].dateOfBirth", everyItem(notNullValue())));



    }

}

