package com.dutmdcjf.covidhosp.batch;

import com.dutmdcjf.covidhosp.entity.Hospital;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class HospDownloadBatch {

    /* *
     * 공공데이터 작동 테스트
     * url: API 주소(JSON 변환)
     */
    @Test
    public void initTest() {
        RestTemplate rt = new RestTemplate();
        String url = "http://apis.data.go.kr/B551182/rprtPtntDiagCnfcInfoService1/getRprtPtntDiagCnfcInfo1?serviceKey=cz0r5X/Kjyv15o4O/OBvIEZCD2AfTez1nS4GTYBrQbfJio2O5YrWQIv28MhQb1Dhbysq8iDFZ9wNT35K303p/w==&numOfRows=10&pageNo=1&_type=json";
        ResponseDTO responseDTO = rt.getForObject(url, ResponseDTO.class);
        System.out.println(responseDTO);

        List<Item> hospital = responseDTO.getResponse().getBody().getItems().getItem();
        for (Item hosp : hospital) {
            System.out.println(hosp.getYadmNm());
        }

        /*String dto = rt.getForObject(url, String.class);
        System.out.println(dto);*/

    }

    /* *
     * 코로나 병원 전부 받아오기
     */
    @Test
    public void hospitalDownload() {
        List<Hospital> hospitals = new ArrayList<>();
        RestTemplate rt = new RestTemplate();

        String tmpUrl = "http://apis.data.go.kr/B551182/rprtPtntDiagCnfcInfoService1/getRprtPtntDiagCnfcInfo1?serviceKey=cz0r5X/Kjyv15o4O/OBvIEZCD2AfTez1nS4GTYBrQbfJio2O5YrWQIv28MhQb1Dhbysq8iDFZ9wNT35K303p/w==&numOfRows=2&pageNo=1&_type=json";
        ResponseDTO tmpResponseDTO = rt.getForObject(tmpUrl, ResponseDTO.class);
        int totalCount = tmpResponseDTO.getResponse().getBody().getTotalCount();

        String url = "http://apis.data.go.kr/B551182/rprtPtntDiagCnfcInfoService1/getRprtPtntDiagCnfcInfo1?serviceKey=cz0r5X/Kjyv15o4O/OBvIEZCD2AfTez1nS4GTYBrQbfJio2O5YrWQIv28MhQb1Dhbysq8iDFZ9wNT35K303p/w==&numOfRows=" +
                totalCount + "&pageNo=1&_type=json";
        ResponseDTO responseDTO = rt.getForObject(url, ResponseDTO.class);
        List<Item> items = responseDTO.getResponse().getBody().getItems().getItem();

        hospitals = items.stream().map(item -> {
            return Hospital.builder()
                    .addr(item.getAddr())
                    .cv19ExmTyCd(item.getCv19ExmTyCd())
                    .dgmPrscPsblYn(item.getDgmPrscPsblYn())
                    .infcPtntDiagTyCd(item.getInfcPtntDiagTyCd())
                    .onstpMadmYn(item.getOnstpMadmYn())
                    .rprtPtntDiagPsblYn(item.getRprtPtntDiagPsblYn())
                    .sgguNm(item.getSgguNm())
                    .sidoNm(item.getSidoNm())
                    .yadmNm(item.getYadmNm())
                    .ykiho(item.getYkiho())
                    .build();
        }).collect(Collectors.toList());
        System.out.println(totalCount);
        assertThat(hospitals.size()).isEqualTo(totalCount);
    }
}
