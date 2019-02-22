package com.yonetim.dao;

import com.yonetim.dto.YonetimDTO;

public interface IYonetimDAO {

    boolean kaydet(YonetimDTO yonetimDTO) throws Exception;
}
