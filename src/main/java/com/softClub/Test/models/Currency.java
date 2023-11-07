package com.softClub.Test.models;

import jakarta.persistence.Entity;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Entity class for storing ValuteCursOnDate data.
 */
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Currency)) return false;
        Currency currency = (Currency) o;
        return Objects.equals(vname, currency.vname) && Objects.equals(vnom, currency.vnom) && Objects.equals(vcurs, currency.vcurs) && Objects.equals(vcode, currency.vcode) && Objects.equals(vchCode, currency.vchCode) && Objects.equals(vunitRate, currency.vunitRate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vname, vnom, vcurs, vcode, vchCode, vunitRate);
    }
}
