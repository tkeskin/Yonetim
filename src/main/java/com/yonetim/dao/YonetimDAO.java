package com.yonetim.dao;

import com.yonetim.dto.BasvuruDTO;
import com.yonetim.dto.BasvuruSahibiDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class YonetimDAO implements IYonetimDAO {

    @Autowired
    YonetimRepository yonetimRepository;

    @Autowired
    BasvuruSahibiRepository basvuruSahibiRepository;

    @Override
    public boolean save(BasvuruDTO basvuruDTO) throws Exception {
        yonetimRepository.save(basvuruDTO);
        return false;
    }

    @Override
    public boolean existApplicant(String name) {
        Collection<BasvuruSahibiDTO> basvuruSahibiDTOS = basvuruSahibiRepository.existsApplicant(name);
        return false;
    }

    @Override
    public boolean save(BasvuruSahibiDTO basvuruSahibiDTO) throws Exception {
        basvuruSahibiRepository.save(basvuruSahibiDTO);
        return false;
    }

    @Override
    public Iterable<BasvuruDTO> fetchAll() throws Exception{
        return yonetimRepository.findAll();
    }


}
