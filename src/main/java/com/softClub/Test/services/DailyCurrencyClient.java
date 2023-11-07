package com.softClub.Test.services;

import com.softClub.Test.client.gen.GetCursOnDate;
import com.softClub.Test.client.gen.GetCursOnDateResponse;
import com.softClub.Test.client.gen.ObjectFactory;
import com.softClub.Test.client.models.generated.ValuteData;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Unmarshaller;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;
import org.w3c.dom.NodeList;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DailyCurrencyClient extends WebServiceGatewaySupport {
    private NodeList nodes;

    public List<ValuteData.ValuteCursOnDate> getCursOnDate(LocalDateTime timeStamp){
        GetCursOnDate request = new ObjectFactory().createGetCursOnDate();
        XMLGregorianCalendar calendar = DatatypeFactory
                .newDefaultInstance()
                .newXMLGregorianCalendar(timeStamp.toString());
        request.setOnDate(calendar);

        SoapActionCallback action = new SoapActionCallback("http://web.cbr.ru/GetCursOnDate");
        getWebServiceTemplate().marshalSendAndReceive(request, action);

        List<ValuteData.ValuteCursOnDate> list = new ArrayList<>();

        try {
            JAXBContext jc = JAXBContext.newInstance(ValuteData.ValuteCursOnDate.class);
            Unmarshaller u = jc.createUnmarshaller();

            for (int i = 0; i < nodes.getLength(); i++) {
                list.add(u.unmarshal(nodes.item(i), ValuteData.ValuteCursOnDate.class).getValue());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public void setNodes(NodeList nodes) {
        this.nodes = nodes;
    }
}
