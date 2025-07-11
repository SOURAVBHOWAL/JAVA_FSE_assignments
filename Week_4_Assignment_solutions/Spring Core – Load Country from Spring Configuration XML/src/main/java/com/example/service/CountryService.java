package com.example.service;

import com.example.model.Country;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {
    
    private List<Country> countries;
    
    // Constructor injection - countries will be injected from XML configuration
    public CountryService(List<Country> countries) {
        this.countries = countries;
    }
    
    public List<Country> getAllCountries() {
        return countries;
    }
    
    public Optional<Country> getCountryById(Long id) {
        return countries.stream()
                .filter(country -> country.getId().equals(id))
                .findFirst();
    }
    
    public Optional<Country> getCountryByCode(String code) {
        return countries.stream()
                .filter(country -> country.getCode().equalsIgnoreCase(code))
                .findFirst();
    }
    
    public List<Country> getCountriesByContinent(String continent) {
        return countries.stream()
                .filter(country -> country.getContinent().equalsIgnoreCase(continent))
                .toList();
    }
    
    public Country addCountry(Country country) {
        // Generate new ID
        Long maxId = countries.stream()
                .mapToLong(Country::getId)
                .max()
                .orElse(0L);
        country.setId(maxId + 1);
        
        countries.add(country);
        return country;
    }
    
    public Optional<Country> updateCountry(Long id, Country updatedCountry) {
        for (int i = 0; i < countries.size(); i++) {
            if (countries.get(i).getId().equals(id)) {
                updatedCountry.setId(id);
                countries.set(i, updatedCountry);
                return Optional.of(updatedCountry);
            }
        }
        return Optional.empty();
    }
    
    public boolean deleteCountry(Long id) {
        return countries.removeIf(country -> country.getId().equals(id));
    }
}
