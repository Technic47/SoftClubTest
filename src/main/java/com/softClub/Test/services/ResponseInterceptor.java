package com.softClub.Test.services;

import jakarta.xml.soap.MessageFactory;
import jakarta.xml.soap.SOAPBody;
import jakarta.xml.soap.SOAPMessage;
import org.springframework.ws.client.WebServiceClientException;
import org.springframework.ws.client.support.interceptor.ClientInterceptor;
import org.springframework.ws.context.MessageContext;
import org.springframework.ws.soap.saaj.SaajSoapMessage;
import org.springframework.ws.soap.saaj.SaajSoapMessageFactory;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class ResponseInterceptor implements ClientInterceptor {
    private final DailyCurrencyClient client;

    public ResponseInterceptor(DailyCurrencyClient client) {
        this.client = client;
    }

    @Override
    public boolean handleRequest(MessageContext messageContext) throws WebServiceClientException {
        return true;
    }

    @Override
    public boolean handleResponse(MessageContext messageContext) throws WebServiceClientException {
        return true;
    }

    @Override
    public boolean handleFault(MessageContext messageContext) throws WebServiceClientException {
        return false;
    }

    @Override
    public void afterCompletion(MessageContext messageContext, Exception e) throws WebServiceClientException {
        try (OutputStream s = new ByteArrayOutputStream()) {
            SaajSoapMessage message = (SaajSoapMessage) messageContext.getResponse();

            message.writeTo(s);

//            String response = s.toString();
//            System.out.println("SOAP RESPONSE: " + response);
            SOAPMessage saajMessage = message.getSaajMessage();
            SOAPBody soapBody = saajMessage.getSOAPBody();
            NodeList valuteCursOnDate = soapBody.getElementsByTagName("ValuteCursOnDate");

            client.setNodes(valuteCursOnDate);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
