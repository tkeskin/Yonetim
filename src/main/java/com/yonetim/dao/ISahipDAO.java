package com.yonetim.dao;

import com.yonetim.dto.PlantDTO;
import com.yonetim.dto.SahipDTO;
import java.util.List;

/**
 * tkeskin .
 */
public interface ISahipDAO {
    List<PlantDTO> kayitAl(String arananKelime) throws Exception;

    List<SahipDTO> kayitAlManuel(String arananKelime) throws Exception;
}
