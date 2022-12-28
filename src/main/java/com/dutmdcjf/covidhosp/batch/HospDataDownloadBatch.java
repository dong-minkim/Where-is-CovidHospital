package com.dutmdcjf.covidhosp.batch;

import com.dutmdcjf.covidhosp.entity.Hospital;
import com.dutmdcjf.covidhosp.repository.HospitalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/* *
 * 매일 병원 갱신
 * 공공데이터 하루 트래픽 1000
 */
@Component
@RequiredArgsConstructor
public class HospDataDownloadBatch {

    private final HospitalRepository hospitalRepository;

    @Scheduled(cron = "0 0 3 * * *", zone = "Asia/Seoul")
    public void downloadBatch() {
        List<Hospital> hospitals = new ArrayList<>();
        RestTemplate rt = new RestTemplate();

        String tmpUrl = "http://apis.data.go.kr/B551182/rprtPtntDiagCnfcInfoService1/getRprtPtntDiagCnfcInfo1?serviceKey=cz0r5X/Kjyv15o4O/OBvIEZCD2AfTez1nS4GTYBrQbfJio2O5YrWQIv28MhQb1Dhbysq8iDFZ9wNT35K303p/w==&numOfRows=2&pageNo=1&_type=json";
        ResponseDTO tmpResponseDTO = rt.getForObject(tmpUrl, ResponseDTO.class);
        int totalCount = tmpResponseDTO.getResponse().getBody().getTotalCount();
        System.out.println(totalCount);
        String url = "http://apis.data.go.kr/B551182/rprtPtntDiagCnfcInfoService1/getRprtPtntDiagCnfcInfo1?serviceKey=cz0r5X/Kjyv15o4O/OBvIEZCD2AfTez1nS4GTYBrQbfJio2O5YrWQIv28MhQb1Dhbysq8iDFZ9wNT35K303p/w==&numOfRows=" +
                totalCount + "&pageNo=1&_type=json";
        ResponseDTO responseDTO = rt.getForObject(url, ResponseDTO.class);
        List<Item> items = responseDTO.getResponse().getBody().getItems().getItem();

        hospitals = items.stream().map(item -> {
            return Hospital.builder()
                    .addr(item.getAddr())
                    .cv19ExmTyCd(item.getCv19ExmTyCd())
                    .dgmPrscPsblYn(item.getDgmPrscPsblYn())
                    .diagBknPsblTelno(item.getDiagBknPsblTelno())
                    .infcPtntDiagTyCd(item.getInfcPtntDiagTyCd())
                    .onstpMadmYn(item.getOnstpMadmYn())
                    .rprtPtntDiagPsblYn(item.getRprtPtntDiagPsblYn())
                    .sgguNm(item.getSgguNm())
                    .sidoNm(item.getSidoNm())
                    .yadmNm(item.getYadmNm())
                    .ykiho(item.getYkiho())
                    .build();
        }).collect(Collectors.toList());

        hospitalRepository.deleteAll();

        hospitalRepository.saveAll(hospitals);
    }
}
