package com.softClub.Test.webclient;

import jakarta.xml.bind.Marshaller;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.support.interceptor.ClientInterceptor;

import java.util.HashMap;

public abstract class AbstractWebClientTest {
    protected static String URI;
    public static Jaxb2Marshaller getMarshaller() throws Exception {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setMarshallerProperties(new HashMap<>() {{
            put(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        }});
        marshaller.setContextPaths(
                "com.softClub.Test.client.gen");
        marshaller.afterPropertiesSet();
        return marshaller;
    }

    public static DailyCurrencyClient getClient(Jaxb2Marshaller marshaller) {
        DailyCurrencyClient client = new DailyCurrencyClient();
        client.setDefaultUri(URI);
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }

    public static void setURI(String URI) {
        AbstractWebClientTest.URI = URI;
    }
}
