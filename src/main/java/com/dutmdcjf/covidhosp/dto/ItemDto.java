package com.dutmdcjf.covidhosp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemDto {

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
