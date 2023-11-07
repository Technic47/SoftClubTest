package com.softClub.Test.models.XMLparse;

import jakarta.xml.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "valuteCursOnDate"
})
@XmlRootElement(name = "ValuteData")
public class CurrencyData {
    @XmlElement(name = "ValuteCursOnDate")
    protected List<Currency> valuteCursOnDate;

    public List<Currency> getValuteCursOnDate() {
        if (valuteCursOnDate == null) {
            valuteCursOnDate = new ArrayList<>();
        }
        return this.valuteCursOnDate;
    }
}
