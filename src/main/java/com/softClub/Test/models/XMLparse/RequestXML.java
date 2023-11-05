package com.softClub.Test.models.XMLparse;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlRootElement(name = "GetCursOnDate")
public class RequestXML {
    @XmlElement(name = "On_date", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar onDate;

    public XMLGregorianCalendar getOnDate() {
        return onDate;
    }

    public void setOnDate(XMLGregorianCalendar onDate) {
        this.onDate = onDate;
    }
}
