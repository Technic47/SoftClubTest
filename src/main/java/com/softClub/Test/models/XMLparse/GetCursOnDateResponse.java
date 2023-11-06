//package com.softClub.Test.models.XMLparse;
//
//import com.softClub.Test.client.gen.Schema;
//import com.softClub.Test.client.gen.ValuteData;
//import jakarta.xml.bind.annotation.*;
//
//@XmlAccessorType(XmlAccessType.FIELD)
//@XmlType(name = "", propOrder = {
//        "getCursOnDateResult"
//})
//@XmlRootElement(name = "GetCursOnDateResponse")
//public class GetCursOnDateResponse {
//    @XmlElement(name = "GetCursOnDateResult")
//    protected GetCursOnDateResponse.GetCursOnDateResult getCursOnDateResult;
//
//    public GetCursOnDateResponse.GetCursOnDateResult getGetCursOnDateResult() {
//        return getCursOnDateResult;
//    }
//
//    public void setGetCursOnDateResult(GetCursOnDateResponse.GetCursOnDateResult getCursOnDateResult) {
//        this.getCursOnDateResult = getCursOnDateResult;
//    }
//
//    @XmlAccessorType(XmlAccessType.FIELD)
//    @XmlType(name = "", propOrder = {
//            "schema",
//            "any"
//    })
//    @XmlSeeAlso(ValuteData.class)
//    public static class GetCursOnDateResult {
//
//        @XmlElement(namespace = "http://www.w3.org/2001/XMLSchema", required = true)
//        protected Schema schema;
//        @XmlElement(name = "ValuteData")
//        protected ValuteData any;
//
//        /**
//         * Gets the value of the schema property.
//         *
//         * @return possible object is
//         * {@link Schema }
//         */
//        public Schema getSchema() {
//            return schema;
//        }
//
//        /**
//         * Sets the value of the schema property.
//         *
//         * @param value allowed object is
//         *              {@link Schema }
//         */
//        public void setSchema(Schema value) {
//            this.schema = value;
//        }
//
//        /**
//         * Gets the value of the any property.
//         *
//         * @return possible object is
//         * {@link Object }
//         */
//        public ValuteData getAny() {
//            return any;
//        }
//
//        /**
//         * Sets the value of the any property.
//         *
//         * @param value allowed object is
//         *              {@link Object }
//         */
//        public void setAny(ValuteData value) {
//            this.any = value;
//        }
//
//    }
//}
