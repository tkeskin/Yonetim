package com.yonetim.dao;

import com.yonetim.dto.BasvuruDTO;
import com.yonetim.dto.BasvuruSahibiDTO;

/**
 * tkeskin .
 */
public interface IYonetimDAO {
    boolean existApplicant(String name);

    boolean save(BasvuruSahibiDTO basvuruSahibiDTO) throws Exception;

    boolean save(BasvuruDTO basvuruDTO) throws Exception;

    Iterable<BasvuruDTO> fetchAll() throws Exception;
}
