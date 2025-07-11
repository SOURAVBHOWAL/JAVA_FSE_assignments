package com.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Country {
    
    @NotNull(message = "Country ID cannot be null")
    @JsonProperty("id")
    private Long id;
    
    @NotBlank(message = "Country name cannot be blank")
    @Size(min = 2, max = 100, message = "Country name must be between 2 and 100 characters")
    @JsonProperty("name")
    private String name;
    
    @NotBlank(message = "Country code cannot be blank")
    @Size(min = 2, max = 3, message = "Country code must be 2 or 3 characters")
    @JsonProperty("code")
    private String code;
    
    @JsonProperty("capital")
    private String capital;
    
    @JsonProperty("population")
    private Long population;
    
    @JsonProperty("continent")
    private String continent;
    
    // Default constructor
    public Country() {}
    
    // Parameterized constructor
    public Country(Long id, String name, String code, String capital, Long population, String continent) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.capital = capital;
        this.population = population;
        this.continent = continent;
    }
    
    // Getters and Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getCode() {
        return code;
    }
    
    public void setCode(String code) {
        this.code = code;
    }
    
    public String getCapital() {
        return capital;
    }
    
    public void setCapital(String capital) {
        this.capital = capital;
    }
    
    public Long getPopulation() {
        return population;
    }
    
    public void setPopulation(Long population) {
        this.population = population;
    }
    
    public String getContinent() {
        return continent;
    }
    
    public void setContinent(String continent) {
        this.continent = continent;
    }
    
    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", capital='" + capital + '\'' +
                ", population=" + population +
                ", continent='" + continent + '\'' +
                '}';
    }
}
