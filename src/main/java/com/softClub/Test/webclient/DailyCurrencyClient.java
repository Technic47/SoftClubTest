package com.softClub.Test.webclient;

import com.softClub.Test.client.gen.GetCursOnDate;
import com.softClub.Test.client.models.generated.ValuteData;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Unmarshaller;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;
import org.w3c.dom.NodeList;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Client for connecting to SOAP service.
 */
public class DailyCurrencyClient extends WebServiceGatewaySupport {
    private NodeList nodes;

    /**
     * Main procedure for sending request and consuming response.
     *
     * @param timeStamp argument for GetCursOnDate service.
     * @return List ValuteCursOnDate objects.
     */
    public List<ValuteData.ValuteCursOnDate> getCursOnDate(LocalDateTime timeStamp) {
        GetCursOnDate request = constructRequest(timeStamp);

        SoapActionCallback action = new SoapActionCallback("http://web.cbr.ru/GetCursOnDate");
        getWebServiceTemplate().marshalSendAndReceive(request, action);

        return formListOfData();
    }

    /**
     * Request - object constructor.
     *
     * @param timeStamp timestamp argument.
     * @return GetCursOnDate object.
     */
    private GetCursOnDate constructRequest(LocalDateTime timeStamp) {
        GetCursOnDate request = new GetCursOnDate();
        XMLGregorianCalendar calendar = DatatypeFactory
                .newDefaultInstance()
                .newXMLGregorianCalendar(timeStamp.toString());
        request.setOnDate(calendar);
        return request;
    }

    /**
     * Unmarshal Nodes to usefull data.
     *
     * @return List of ValuteCursOnDate objects.
     */
    private List<ValuteData.ValuteCursOnDate> formListOfData() {
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
