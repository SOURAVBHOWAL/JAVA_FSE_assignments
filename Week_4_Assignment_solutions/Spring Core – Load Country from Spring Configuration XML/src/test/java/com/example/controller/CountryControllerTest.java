package com.example.controller;

import com.example.model.Country;
import com.example.service.CountryService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CountryController.class)
public class CountryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CountryService countryService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testGetAllCountries() throws Exception {
        Country country1 = new Country(1L, "USA", "US", "Washington D.C.", 331900000L, "North America");
        Country country2 = new Country(2L, "India", "IN", "New Delhi", 1380004385L, "Asia");
        
        when(countryService.getAllCountries()).thenReturn(Arrays.asList(country1, country2));

        mockMvc.perform(get("/api/countries"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].name").value("USA"))
                .andExpect(jsonPath("$[1].name").value("India"));
    }

    @Test
    public void testGetCountryById() throws Exception {
        Country country = new Country(1L, "USA", "US", "Washington D.C.", 331900000L, "North America");
        
        when(countryService.getCountryById(1L)).thenReturn(Optional.of(country));

        mockMvc.perform(get("/api/countries/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name").value("USA"));
    }

    @Test
    public void testCreateCountry() throws Exception {
        Country country = new Country(1L, "Canada", "CA", "Ottawa", 38000000L, "North America");
        
        when(countryService.addCountry(any(Country.class))).thenReturn(country);

        mockMvc.perform(post("/api/countries")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(country)))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name").value("Canada"));
    }
}