package com.yonetim.service;

import com.yonetim.dao.ISahipDAO;
import com.yonetim.dao.IYonetimDAO;
import com.yonetim.dto.BasvuruDTO;
import com.yonetim.dto.PlantDTO;
import com.yonetim.dto.SahipDTO;
import com.yonetim.dto.BasvuruSahibiDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class YonetimService implements IYonetimService{

    @Autowired
    ISahipDAO sahipDAO;

    @Autowired
    IYonetimDAO yonetimDAO;

    public BasvuruSahibiDTO getId(int i){
        BasvuruSahibiDTO basvuruSahibiDTO = new BasvuruSahibiDTO();
        //basvuruSahibiDTO.setId(i);
        basvuruSahibiDTO.setAd("TestAd");
        basvuruSahibiDTO.setSoyad("TestSoyad");
        //basvuruSahibiDTO.setAciklama("TestAciklama");
        return basvuruSahibiDTO;
    }

    @Override
    public boolean existApplicant(String tckn) throws Exception {
        yonetimDAO.existApplicant(tckn);
        return false;
    }

    @Override
    public boolean save(BasvuruDTO basvuruDTO) throws Exception{
        yonetimDAO.save(basvuruDTO);
        return false;
    }
    @Override
    public boolean save(BasvuruSahibiDTO basvuruSahibiDTO) throws Exception{
        yonetimDAO.save(basvuruSahibiDTO);
        return false;
    }


    /**
     *
     * @param
     * @return bütün kayıtları listeler
     * @throws Exception
     */
    @Override
    public Iterable<BasvuruDTO> fetchAllYonetim() throws Exception{
        return yonetimDAO.fetchAll();
    }

    @Override
    public List<SahipDTO> kayitAlManuel(String arama) throws Exception{
        return sahipDAO.kayitAlManuel("Oak");
    }

    @Override
    public List<PlantDTO> kayitAl(String aranacakKelime) throws Exception{
        return sahipDAO.kayitAl(aranacakKelime);
    }


}
