package at.tmobile.ms.service;


import at.tmobile.ms.client.CountriesSoapClient;
import at.tmobile.ms.model.soap.ws.client.GetCountryRequest;
import at.tmobile.ms.model.soap.ws.client.GetCountryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import at.lun.ms.country.dto.Country;
import at.lun.ms.country.dto.Currency;


import java.util.Optional;

@Service
public class CountryService {

    @Autowired
    CountriesSoapClient countriesSoapClient;

    public Optional<Country> getCountryByName(String name) {

        GetCountryRequest request = new GetCountryRequest();
        request.setName(name);

        GetCountryResponse response = (GetCountryResponse) countriesSoapClient.callService(request);

        Optional<at.tmobile.ms.model.soap.ws.client.Country> soapCountryOpt = Optional.ofNullable(response.getCountry());

        return soapCountryOpt.map(c -> new Country(
                response.getCountry().getName(),
                response.getCountry().getPopulation(),
                response.getCountry().getCapital(),
                Currency.valueOf(response.getCountry().getCurrency().name())));
    }
}
