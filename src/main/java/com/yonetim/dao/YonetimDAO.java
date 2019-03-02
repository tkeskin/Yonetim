package com.yonetim.dao;

import com.yonetim.dto.YonetimDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class YonetimDAO implements IYonetimDAO {

    @Autowired
    YonetimRepository yonetimRepository;
    @Override
    public boolean save(YonetimDTO yonetimDTO) throws Exception {
        yonetimRepository.save(yonetimDTO);
        return false;
    }

    @Override
    public Iterable<YonetimDTO> fetchAll() throws Exception{
        return yonetimRepository.findAll();
    }
}
