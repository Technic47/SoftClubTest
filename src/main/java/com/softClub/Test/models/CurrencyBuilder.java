package com.softClub.Test.models;

import java.math.BigDecimal;

public class CurrencyBuilder {
    private String vname;
    private BigDecimal vnom;
    private BigDecimal vcurs;
    private Integer vcode;
    private String vchCode;
    private Double vunitRate;

    public CurrencyBuilder setVname(String vname) {
        this.vname = vname;
        return this;
    }

    public CurrencyBuilder setVnom(BigDecimal vnom) {
        this.vnom = vnom;
        return this;
    }

    public CurrencyBuilder setVcurs(BigDecimal vcurs) {
        this.vcurs = vcurs;
        return this;
    }

    public CurrencyBuilder setVcode(Integer vcode) {
        this.vcode = vcode;
        return this;
    }

    public CurrencyBuilder setVchCode(String vchCode) {
        this.vchCode = vchCode;
        return this;
    }

    public CurrencyBuilder setVunitRate(Double vunitRate) {
        this.vunitRate = vunitRate;
        return this;
    }

    public Currency createCurrency() {
        return Currency.createCurrency(vname, vnom, vcurs, vcode, vchCode, vunitRate);
    }
}