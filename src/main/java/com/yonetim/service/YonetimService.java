package com.yonetim.service;

import com.yonetim.dao.ISahipDao;
import com.yonetim.dao.IYonetimDao;
import com.yonetim.dto.BasvuruDto;
import com.yonetim.dto.BasvuruSahibiDto;
import com.yonetim.dto.PlantDto;
import com.yonetim.dto.SahipDto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * tkeskin .
 */

@Component
public class YonetimService implements IYonetimService {

  @Autowired
  ISahipDao sahipDao;

  @Autowired
  IYonetimDao yonetimDao;

  /**
   * @param i .
   * @return .
   */
  public BasvuruSahibiDto getId(int i) {
    BasvuruSahibiDto basvuruSahibiDto = new BasvuruSahibiDto();
    //basvuruSahibiDto.setId(i);
    basvuruSahibiDto.setAd("TestAd");
    basvuruSahibiDto.setSoyad("TestSoyad");
    //basvuruSahibiDto.setAciklama("TestAciklama");
    return basvuruSahibiDto;
  }

  @Override
  public boolean existApplicant(String tckn) throws Exception {
    yonetimDao.existApplicant(tckn);
    return false;
  }

  @Override
  public boolean save(BasvuruDto basvuruDto) throws Exception {
    yonetimDao.save(basvuruDto);
    return false;
  }

  @Override
  public boolean save(BasvuruSahibiDto basvuruSahibiDto) throws Exception {
    yonetimDao.save(basvuruSahibiDto);
    return false;
  }

  /**
   * @return .
   * @throws Exception .
   */
  @Override
  public Iterable<BasvuruDto> fetchAllYonetim() throws Exception {
    return yonetimDao.fetchAll();
  }

  @Override
  public List<SahipDto> kayitAlManuel(String arama) throws Exception {
    return sahipDao.kayitAlManuel("Oak");
  }

  @Override
  public List<PlantDto> kayitAl(String aranacakKelime) throws Exception {
    return sahipDao.kayitAl(aranacakKelime);
  }
}