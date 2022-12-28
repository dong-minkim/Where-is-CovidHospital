package com.dutmdcjf.covidhosp.service;

import com.dutmdcjf.covidhosp.dto.ItemDto;
import com.dutmdcjf.covidhosp.entity.Hospital;
import com.dutmdcjf.covidhosp.repository.HospitalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HospitalService {

    private final HospitalRepository hospitalRepository;

    public List<String> getSidoNm() {
        return hospitalRepository.findSidoNms();
    }

    public List<String> getSgguNm(String sidoNm) {
        return hospitalRepository.findSgguNms(sidoNm);
    }

    public List<ItemDto> getHospitalBySearch(String search) {
        List<Hospital> hospitals = hospitalRepository.findAllBySearch(search);

        return addInfoToHospital(hospitals);
    }

    public List<ItemDto> getHospital(String sidoNm, String sgguNm) {
        return addInfoToHospital(hospitalRepository.findAllBySidoNmAndSgguNm(sidoNm, sgguNm));
    }

    private List<ItemDto> addInfoToHospital(List<Hospital> hospitals) {
        List<ItemDto> hospitalResult = new ArrayList<>();
        for (Hospital hospital : hospitals) {
            String sinsokPsbl = "N";
            String pcrPsbl = "N";

            if (hospital.getCv19ExmTyCd().equals("01") || hospital.getCv19ExmTyCd().equals("03")) {
                sinsokPsbl = "Y";
            }

            if (hospital.getCv19ExmTyCd().equals("02") || hospital.getCv19ExmTyCd().equals("03")) {
                pcrPsbl = "Y";
            }

            ItemDto itemDto = ItemDto.builder()
                    .addr(hospital.getAddr())
                    .cv19ExmTyCd(hospital.getCv19ExmTyCd())
                    .dgmPrscPsblYn(hospital.getDgmPrscPsblYn())
                    .diagBknPsblTelno(hospital.getDiagBknPsblTelno())
                    .infcPtntDiagTyCd(hospital.getInfcPtntDiagTyCd())
                    .onstpMadmYn(hospital.getOnstpMadmYn())
                    .rprtPtntDiagPsblYn(hospital.getRprtPtntDiagPsblYn())
                    .sgguNm(hospital.getSgguNm())
                    .sidoNm(hospital.getSidoNm())
                    .yadmNm(hospital.getYadmNm())
                    .ykiho(hospital.getYkiho())
                    .sinsok(sinsokPsbl)
                    .pcr(pcrPsbl)
                    .build();

            hospitalResult.add(itemDto);
        }
        return hospitalResult;
    }


}
