package com.yonetim.service;

import com.yonetim.dto.BasvuruDto;
import com.yonetim.dto.BasvuruSahibiDto;
import com.yonetim.dto.PlantDto;
import com.yonetim.dto.SahipDto;
import java.util.List;

/**
 * tkeskin .
 */

public interface IYonetimService {
  BasvuruSahibiDto getId(int i);

  boolean existApplicant(String name) throws Exception;

  boolean save(BasvuruSahibiDto basvuruSahibiDto) throws Exception;

  boolean save(BasvuruDto basvuruDto) throws Exception;

  Iterable<BasvuruDto> fetchAllYonetim() throws Exception;

  List<SahipDto> kayitAlManuel(String deneme) throws Exception;

  List<PlantDto> kayitAl(String deneme) throws Exception;
}