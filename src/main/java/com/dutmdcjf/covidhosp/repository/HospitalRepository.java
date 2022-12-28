package com.dutmdcjf.covidhosp.repository;

import com.dutmdcjf.covidhosp.entity.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HospitalRepository extends JpaRepository<Hospital, Integer> {

    @Query(value = "select * from hospital where sidoNm = :sidoNm and sgguNm = :sgguNm order by yadmNm", nativeQuery = true)
    public List<Hospital> findAllBySidoNmAndSgguNm(String sidoNm, String sgguNm);

    @Query(value = "select distinct sidoNm from hospital order by sidoNm", nativeQuery = true)
    public List<String> findSidoNms();

    @Query(value = "select distinct sgguNm from hospital where sidoNm = :sidoNm order by sgguNm", nativeQuery = true)
    public List<String> findSgguNms(String sidoNm);

    @Query(value = "select * from hospital " +
            "where sidoNm like %:search% " +
            "or sgguNm like %:search% " +
            "or yadmNm like %:search% " +
            "or addr like %:search%", nativeQuery = true)
    public List<Hospital> findAllBySearch(String search);
}
