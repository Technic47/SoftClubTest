package com.softClub.Test.services;

import com.softClub.Test.client.gen.GetCursOnDate;
import com.softClub.Test.client.gen.GetCursOnDateResponse;
import com.softClub.Test.client.gen.ObjectFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.time.LocalDateTime;

public class DailyCurrencyClient extends WebServiceGatewaySupport {
    public GetCursOnDateResponse getCursOnDate(LocalDateTime timeStamp) {
        GetCursOnDate request = new ObjectFactory().createGetCursOnDate();
        XMLGregorianCalendar calendar = DatatypeFactory
                .newDefaultInstance()
                .newXMLGregorianCalendar(timeStamp.toString());
        request.setOnDate(calendar);

//        StringWriter stringWriter = new StringWriter();
//
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

//        String defaultUri = getDefaultUri();
        SoapActionCallback action = new SoapActionCallback("http://web.cbr.ru/GetCursOnDate");

        GetCursOnDateResponse response = (GetCursOnDateResponse) getWebServiceTemplate()
                .marshalSendAndReceive(request, action);
//
//        Object any = response.getGetCursOnDateResult().getAny();

        return response;
    }
}
