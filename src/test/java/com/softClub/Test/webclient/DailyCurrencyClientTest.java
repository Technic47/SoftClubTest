package com.softClub.Test.webclient;

import com.softClub.Test.client.models.generated.ValuteData;
import jakarta.xml.bind.Marshaller;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.support.interceptor.ClientInterceptor;
import org.springframework.ws.test.client.MockWebServiceServer;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;

import static java.time.LocalDateTime.now;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.ws.test.client.RequestMatchers.anything;
import static org.springframework.ws.test.client.RequestMatchers.payload;
import static org.springframework.ws.test.client.ResponseCreators.withPayload;


class DailyCurrencyClientTest extends AbstractWebClientTest {
    private static DailyCurrencyClient client;
    private static MockWebServiceServer mockServer;

    @BeforeAll
    static void setUp() throws Exception {
        setURI("http://localhost");
        client = getClient(getMarshaller());
        client.setInterceptors(new ClientInterceptor[]{new ResponseInterceptor(client)});
        mockServer = MockWebServiceServer.createServer(client);
    }

    @Test
    void getCursOnDateTest() throws FileNotFoundException {
        Source responsePayload = new StreamSource(new FileInputStream("src/test/testResources/Response.xml"));

        mockServer.expect(anything()).andRespond(withPayload(responsePayload));

        List<ValuteData.ValuteCursOnDate> cursOnDate = client.getCursOnDate(now());
        assertFalse(cursOnDate.isEmpty());
        assertThat(cursOnDate)
                .isNotNull()
                .hasSize(43);
    }
}