package com.softClub.Test.models.XMLparse;

import com.softClub.Test.client.gen.Schema;
import com.softClub.Test.client.models.generated.ValuteData;
import jakarta.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "getCursOnDateResult"
})
@XmlRootElement(name = "GetCursOnDateResponse")
public class Response {
    @XmlElement(name = "GetCursOnDateResult")
    protected Result getCursOnDateResult;

    public Result getGetCursOnDateResult() {
        return getCursOnDateResult;
    }

    public void setGetCursOnDateResult(Result getCursOnDateResult) {
        this.getCursOnDateResult = getCursOnDateResult;
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "schema",
            "any"
    })
    public static class Result {

        @XmlElement(namespace = "http://www.w3.org/2001/XMLSchema", required = true)
        protected Schema schema;
        @XmlElement(name = "ValuteData")
        protected ValuteData any;

        public Schema getSchema() {
            return schema;
        }

        public void setSchema(Schema value) {
            this.schema = value;
        }

        public ValuteData getAny() {
            return any;
        }

        public void setAny(ValuteData value) {
            this.any = value;
        }

    }
}
