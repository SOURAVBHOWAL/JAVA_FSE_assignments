package com.example.springrest.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.springrest.model.Country;

@Service
public class CountryService {
    private static final Map<String, Country> countryMap = new HashMap<>();

    static {
        countryMap.put("IN", new Country("IN", "India"));
        countryMap.put("US", new Country("US", "United States"));
        countryMap.put("FR", new Country("FR", "France"));
    }

    public List<Country> getAllCountries() {
        return new ArrayList<>(countryMap.values());
    }

    public Country getCountryByCode(String code) {
        return countryMap.get(code.toUpperCase());
    }

    public void addCountry(Country country) {
        countryMap.put(country.getCode().toUpperCase(), country);
    }
}
