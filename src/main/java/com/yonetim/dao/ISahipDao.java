package com.yonetim.dao;

import com.yonetim.dto.PlantDto;
import com.yonetim.dto.SahipDto;
import java.util.List;

/**
 * tkeskin .
 */
public interface ISahipDao {
  List<PlantDto> kayitAl(String arananKelime) throws Exception;

  List<SahipDto> kayitAlManuel(String arananKelime) throws Exception;
}