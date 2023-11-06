package com.softClub.Test.services;

import com.softClub.Test.client.gen.GetCursOnDate;
import com.softClub.Test.client.gen.GetCursOnDateResponse;
import com.softClub.Test.client.gen.ObjectFactory;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.soap.MessageFactory;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;
import org.springframework.ws.soap.saaj.SaajSoapMessageFactory;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;
import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;
import java.time.LocalDateTime;

public class DailyCurrencyClient extends WebServiceGatewaySupport {
    private final static String BEFORE = "<?xml version=\"1.0\" encoding=\"utf-8\"?>" +
            "<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">" +
            "<soap:Body>";
    private final static String AFTER = "</soap:Body></soap:Envelope>";

    public GetCursOnDateResponse getCursOnDate(LocalDateTime timeStamp) {
        GetCursOnDate request = new ObjectFactory().createGetCursOnDate();
        XMLGregorianCalendar calendar = DatatypeFactory
                .newDefaultInstance()
                .newXMLGregorianCalendar(timeStamp.toString());
        request.setOnDate(calendar);
//        StringWriter stringWriter = new StringWriter();

//        try {
//            Jaxb2Marshaller springMarshaller = (Jaxb2Marshaller) getWebServiceTemplate().getMarshaller();
//            Result result = new StreamResult(stringWriter);
//            springMarshaller.marshal(request, result);
//
//            System.out.println(stringWriter);
//            System.out.println();
//            String record = BEFORE + stringWriter + AFTER;
//            System.out.println(record);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        String defaultUri = getDefaultUri();
        SoapActionCallback action = new SoapActionCallback("http://web.cbr.ru/GetCursOnDate");

        return (GetCursOnDateResponse) getWebServiceTemplate()
                .marshalSendAndReceive(request, action);
    }
}
