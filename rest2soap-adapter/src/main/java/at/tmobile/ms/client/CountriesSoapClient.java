package at.tmobile.ms.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

@Component
public class CountriesSoapClient extends WebServiceGatewaySupport {

    @Value("${soap.client.url}")
    private String clientUrl;

    public Object callService(Object request) {
        return getWebServiceTemplate().marshalSendAndReceive(clientUrl, request);
    }

}
