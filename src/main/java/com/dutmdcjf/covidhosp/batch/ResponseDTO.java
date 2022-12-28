package com.dutmdcjf.covidhosp.batch;

import lombok.Data;

import java.util.List;

@Data
class Body {

    private Items items;
    private Integer numOfRows;
    private Integer pageNo;
    private Integer totalCount;

}

@Data
class Header {

    private String resultCode;
    private String resultMsg;

}

@Data
class Item {

    private String addr;
    private String cv19ExmTyCd;
    private String dgmPrscPsblYn;
    private String diagBknPsblTelno;
    private String infcPtntDiagTyCd;
    private String onstpMadmYn;
    private String rprtPtntDiagPsblYn;
    private String sgguNm;
    private String sidoNm;
    private String yadmNm;
    private String ykiho;

    private String sinsok;
    private String pcr;

}

@Data
class Items {

    private List<Item> item = null;

}

@Data
class Response {

    private Header header;
    private Body body;

}

@Data
public class ResponseDTO {

    private Response response;

}

