package com.yonetim.dao;

import com.yonetim.dto.YonetimDTO;

public interface IYonetimDAO {
    boolean save(YonetimDTO yonetimDTO) throws Exception;
    Iterable<YonetimDTO> fetchAll() throws Exception;
}
