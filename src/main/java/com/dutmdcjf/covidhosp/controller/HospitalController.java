package com.dutmdcjf.covidhosp.controller;

import com.dutmdcjf.covidhosp.dto.ItemDto;
import com.dutmdcjf.covidhosp.entity.Hospital;
import com.dutmdcjf.covidhosp.repository.HospitalRepository;
import com.dutmdcjf.covidhosp.service.HospitalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class HospitalController {

    private static final String firstSidoNm = "강원";

    private final HospitalService hospitalService;

    @GetMapping("/")
    public String init(Model model) {
        model.addAttribute("sidoNms", hospitalService.getSidoNm());
        model.addAttribute("sgguNms", hospitalService.getSgguNm(firstSidoNm));

        return "index";
    }

    @GetMapping("/sgguNm")
    @ResponseBody
    public List<String> getSgguNms(String sidoNm) {
        return hospitalService.getSgguNm(sidoNm);
    }

    @GetMapping("/hospital")
    @ResponseBody
    public List<ItemDto> getHospitals(String sidoNm, String sgguNm) {
        return hospitalService.getHospital(sidoNm, sgguNm);
    }

    @GetMapping("/search")
    @ResponseBody
    public List<ItemDto> getHospitalsBySearch(String search) {
        return hospitalService.getHospitalBySearch(search);
    }

    @GetMapping("/map")
    public String map(@RequestParam String yadmNm, @RequestParam String addr, @RequestParam String diagBknPsblTelno, Model model) {
        model.addAttribute("yadmNm", yadmNm);
        model.addAttribute("addr", addr);
        model.addAttribute("tel", diagBknPsblTelno);
        System.out.println(addr);
        return "map";
    }
}
