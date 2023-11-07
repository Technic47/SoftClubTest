package com.softClub.Test.models.XMLparse;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

import java.math.BigDecimal;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "vname",
        "vnom",
        "vcurs",
        "vcode",
        "vchCode",
        "vunitRate"
})
public class Currency {
    @XmlElement(name = "Vname")
    protected String vname;
    @XmlElement(name = "Vnom")
    protected BigDecimal vnom;
    @XmlElement(name = "Vcurs")
    protected BigDecimal vcurs;
    @XmlElement(name = "Vcode")
    protected Integer vcode;
    @XmlElement(name = "VchCode")
    protected String vchCode;
    @XmlElement(name = "VunitRate")
    protected Double vunitRate;

    public String getVname() {
        return vname;
    }

    public void setVname(String vname) {
        this.vname = vname;
    }

    public BigDecimal getVnom() {
        return vnom;
    }

    public void setVnom(BigDecimal vnom) {
        this.vnom = vnom;
    }

    public BigDecimal getVcurs() {
        return vcurs;
    }

    public void setVcurs(BigDecimal vcurs) {
        this.vcurs = vcurs;
    }

    public Integer getVcode() {
        return vcode;
    }

    public void setVcode(Integer vcode) {
        this.vcode = vcode;
    }

    public String getVchCode() {
        return vchCode;
    }

    public void setVchCode(String vchCode) {
        this.vchCode = vchCode;
    }

    public Double getVunitRate() {
        return vunitRate;
    }

    public void setVunitRate(Double vunitRate) {
        this.vunitRate = vunitRate;
    }
}
