package com.dutmdcjf.covidhosp.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@Entity
public class Hospital {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String addr;               //주소
    private String cv19ExmTyCd;        //코로나바이러스감염증-19 검사유형코드
    private String dgmPrscPsblYn;      //약제처방가능여부
    private String diagBknPsblTelno;   //진료예약가능전화번호
    private String infcPtntDiagTyCd;   //감염환자진료유형코드
    private String onstpMadmYn;        //원스톱의료기관여부
    private String rprtPtntDiagPsblYn; //호흡기환자진료가능여부
    private String sgguNm; //시군구명
    private String sidoNm; //시도명
    private String yadmNm; //요양기관명
    private String ykiho;  //암호화된 요양기호

}
