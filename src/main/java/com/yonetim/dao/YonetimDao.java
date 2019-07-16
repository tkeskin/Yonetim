package com.yonetim.dao;

import com.yonetim.dto.BasvuruDto;
import com.yonetim.dto.BasvuruSahibiDto;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * tkeskin .
 */

@Component
public class YonetimDao implements IYonetimDao {

  @Autowired
  YonetimRepository yonetimRepository;

  @Autowired
  BasvuruSahibiRepository basvuruSahibiRepository;

  @Override
  public boolean save(BasvuruDto basvuruDto) throws Exception {
    yonetimRepository.save(basvuruDto);
    return false;
  }

  @Override
  public boolean existApplicant(String name) {
    Collection<BasvuruSahibiDto> basvuruSahibiDtos =
        basvuruSahibiRepository.existsApplicant(name);
    return false;
  }

  @Override
  public boolean save(BasvuruSahibiDto basvuruSahibiDto) throws Exception {
    basvuruSahibiRepository.save(basvuruSahibiDto);
    return false;
  }

  @Override
  public Iterable<BasvuruDto> fetchAll() throws Exception {
    return yonetimRepository.findAll();
  }
}