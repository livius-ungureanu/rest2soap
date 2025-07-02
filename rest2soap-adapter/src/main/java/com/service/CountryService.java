package com.service;

import at.tmobile.ms.rlm.dto.Country;
import com.example.consumingwebservice.CountrySoapClient;
import com.example.consumingwebservice.wsdl.GetCountryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryService {

    @Autowired
    CountrySoapClient countrySoapClient;

    public Country getCountryByName(String name) {
        GetCountryResponse response = countrySoapClient.getCountry(name);
        System.out.println(response.getCountry().getCurrency());
        return new Country(
                response.getCountry().getName(),
                response.getCountry().getPopulation(),
                response.getCountry().getCapital(),
                at.tmobile.ms.rlm.dto.Currency.valueOf(response.getCountry().getCurrency().name()));
    }
}
