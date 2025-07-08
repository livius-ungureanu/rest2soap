package at.tmobile.ms;

import at.tmobile.ms.client.CountriesSoapClient;
import at.tmobile.ms.model.soap.ws.client.Country;
import at.tmobile.ms.model.soap.ws.client.Currency;
import at.tmobile.ms.model.soap.ws.client.GetCountryResponse;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.wait.strategy.Wait;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.assertj.core.api.Assertions.assertThat;

@Testcontainers
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CountriesAdapterIntegrationContainerTest {

    @Container
    static GenericContainer<?> soapServer = new GenericContainer<>("localhost/soap-countries-web-service")
            .withExposedPorts(8080);
			//.waitingFor(Wait.forHttp("/ws/countries.wsdl").forStatusCode(200));

    @Autowired
    private TestRestTemplate restTemplate;

    @DynamicPropertySource
    static void configureProperties(@NotNull DynamicPropertyRegistry registry) {
        String soapUrl = "http://" + soapServer.getHost() + ":" + soapServer.getMappedPort(8080) + "/ws";
        registry.add("soap.client.url", () -> soapUrl);
    }

    @Test
    void shouldReturnOkWhenCountryIsFound() {
        ResponseEntity<Country> response = restTemplate.getForEntity("/countries/Spain", Country.class);
        Country country = response.getBody();

        assertThat(response).isNotNull();
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(country).isNotNull();
        assertThat(country.getName()).isEqualTo("Spain");
        assertThat(country.getCapital()).isEqualTo("Madrid");
        assertThat(country.getPopulation()).isEqualTo(46704314);
        assertThat(country.getCurrency()).isEqualTo(Currency.EUR);
    }

    @Test
    void shouldReturnNotFoundWhenCountryIsNotFound() {
        ResponseEntity<Country> response = restTemplate.getForEntity("/countries/France", Country.class);

        assertThat(response).isNotNull();
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }
}

