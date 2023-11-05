package com.softClub.Test.services;

import com.softClub.Test.client.gen.GetCursOnDate;
import com.softClub.Test.client.gen.GetCursOnDateResponse;
import com.softClub.Test.client.gen.ObjectFactory;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.Marshaller;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;
import java.io.StringWriter;
import java.time.LocalDateTime;

public class DailyCurrencyClient extends WebServiceGatewaySupport {
    public GetCursOnDateResponse getCursOnDate(LocalDateTime timeStamp) {
        GetCursOnDate request = new ObjectFactory().createGetCursOnDate();
        XMLGregorianCalendar calendar = DatatypeFactory
                .newDefaultInstance()
                .newXMLGregorianCalendar(timeStamp.toString());
        request.setOnDate(calendar);

//        Jaxb2Marshaller marshaller = (Jaxb2Marshaller) getWebServiceTemplate().getMarshaller();
//        System.out.println(marshaller.getContextPath());
//        Class<?>[] classesToBeBound = marshaller.getClassesToBeBound();
//        for (Class<?> aClass : classesToBeBound) {
//            System.out.println(aClass.getSimpleName());
//        }

//        try {
//            StringWriter stringWriter = new StringWriter();
//            JAXBContext jaxbContext = JAXBContext.newInstance(GetCursOnDate.class.getPackageName(), GetCursOnDate.class.getClassLoader());
//            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
//            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
//                    true);
//
//            QName qName = new QName("com.softClub.Test.client.gen", "GetCursOnDate");
//            JAXBElement<GetCursOnDate> root = new JAXBElement<>(qName, GetCursOnDate.class, request);
//
//            jaxbMarshaller.marshal(root, stringWriter);
//
//            String result = stringWriter.toString();
//            System.out.println(result);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


        return (GetCursOnDateResponse) getWebServiceTemplate()
                .marshalSendAndReceive(request);
    }
}
