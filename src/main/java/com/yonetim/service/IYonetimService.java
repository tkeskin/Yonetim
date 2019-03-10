package com.yonetim.service;

import com.yonetim.dto.BasvuruDTO;
import com.yonetim.dto.PlantDTO;
import com.yonetim.dto.SahipDTO;
import com.yonetim.dto.BasvuruSahibiDTO;

import java.util.List;

public interface IYonetimService {
    BasvuruSahibiDTO getId(int i);
    boolean existApplicant(String name) throws Exception;
    boolean save(BasvuruSahibiDTO basvuruSahibiDTO) throws Exception;
    boolean save(BasvuruDTO basvuruDTO) throws Exception;
    Iterable<BasvuruDTO> fetchAllYonetim() throws Exception;
    List<SahipDTO> kayitAlManuel(String deneme) throws Exception;
    List<PlantDTO> kayitAl(String deneme) throws Exception;
}