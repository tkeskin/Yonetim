package com.yonetim.service;

import com.yonetim.dto.PlantDTO;
import com.yonetim.dto.SahipDTO;
import com.yonetim.dto.YonetimDTO;

import java.util.List;

public interface IYonetimService {
    YonetimDTO getId(int i);
    boolean save(YonetimDTO yonetimDTO) throws Exception;

    Iterable<YonetimDTO> fetchAllYonetim() throws Exception;

    List<SahipDTO> kayitAlManuel(String deneme) throws Exception;
    List<PlantDTO> kayitAl(String deneme) throws Exception;
}