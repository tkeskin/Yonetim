package com.yonetim.dao;

import com.yonetim.dto.BasvuruDto;
import com.yonetim.dto.BasvuruSahibiDto;

/**
 * tkeskin .
 */

public interface IYonetimDao {

  boolean existApplicant(String name);

  boolean save(BasvuruSahibiDto basvuruSahibiDto) throws Exception;

  boolean save(BasvuruDto basvuruDto) throws Exception;

  Iterable<BasvuruDto> fetchAll() throws Exception;
}