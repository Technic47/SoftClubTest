package com.softClub.Test.models;

import jakarta.persistence.Entity;

import java.math.BigDecimal;

@Entity
public class Currency extends AbstractEntity {
    protected String vname;
    protected BigDecimal vnom;
    protected BigDecimal vcurs;
    protected Integer vcode;
    protected String vchCode;
    protected Double vunitRate;

    private Currency(String vname, BigDecimal vnom, BigDecimal vcurs, Integer vcode, String vchCode, Double vunitRate) {
        this.vname = vname;
        this.vnom = vnom;
        this.vcurs = vcurs;
        this.vcode = vcode;
        this.vchCode = vchCode;
        this.vunitRate = vunitRate;
    }

    public Currency() {
    }

    public static Currency createCurrency(String vname, BigDecimal vnom, BigDecimal vcurs, Integer vcode, String vchCode, Double vunitRate) {
        return new Currency(vname, vnom, vcurs, vcode, vchCode, vunitRate);
    }

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
