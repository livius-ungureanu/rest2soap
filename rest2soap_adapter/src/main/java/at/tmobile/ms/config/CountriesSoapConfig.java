package at.tmobile.ms.config;

import at.tmobile.ms.client.CountriesSoapClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class CountriesSoapConfig {

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("at.tmobile.ms.model.soap.ws.client");
        return marshaller;
    }

    @Bean
    public CountriesSoapClient countriesSoapClient(Jaxb2Marshaller marshaller) {
        CountriesSoapClient client = new CountriesSoapClient();
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
}

