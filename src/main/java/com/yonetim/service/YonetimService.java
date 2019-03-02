package com.yonetim.service;

import com.yonetim.dao.ISahipDAO;
import com.yonetim.dao.IYonetimDAO;
import com.yonetim.dto.PlantDTO;
import com.yonetim.dto.SahipDTO;
import com.yonetim.dto.YonetimDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class YonetimService implements IYonetimService{

    @Autowired
    ISahipDAO sahipDAO;

    @Autowired
    IYonetimDAO yonetimDAO;

    public YonetimDTO getId(int i){
        YonetimDTO yonetimDTO = new YonetimDTO();
        yonetimDTO.setId(i);
        yonetimDTO.setAd("TestAd");
        yonetimDTO.setSoyad("TestSoyad");
        yonetimDTO.setAciklama("TestAciklama");
        return yonetimDTO;
    }

    @Override
    public boolean save(YonetimDTO yonetimDTO) throws Exception{
        yonetimDAO.save(yonetimDTO);
        return false;
    }

    /**
     *
     * @param
     * @return bütün kayıtları listeler
     * @throws Exception
     */
    @Override
    public Iterable<YonetimDTO> fetchAllYonetim() throws Exception{
        return yonetimDAO.fetchAll();
    }

    @Override
    public List<SahipDTO> kayitAlManuel(String arama) throws Exception{

        /*List<SahipDTO> eslenleriAtList = new ArrayList<SahipDTO>();

        if(arama.contains("cengiz") || arama.contains("aras")){
            SahipDTO sahipDTO = new SahipDTO();
            sahipDTO.setTc(1);
            sahipDTO.setAd("cengiz aras");
            sahipDTO.setSoyad("keskin");
            eslenleriAtList.add(sahipDTO);
            sahipDAO.kayitAl()
        }
        return eslenleriAtList;*/
        return sahipDAO.kayitAlManuel("Oak");

    }

    @Override
    public List<PlantDTO> kayitAl(String aranacakKelime) throws Exception{

        /*List<SahipDTO> eslenleriAtList = new ArrayList<SahipDTO>();

        if(arama.contains("cengiz") || arama.contains("aras")){
            SahipDTO sahipDTO = new SahipDTO();
            sahipDTO.setTc(1);
            sahipDTO.setAd("cengiz aras");
            sahipDTO.setSoyad("keskin");
            eslenleriAtList.add(sahipDTO);
            sahipDAO.kayitAl()
        }
        return eslenleriAtList;*/
        return sahipDAO.kayitAl(aranacakKelime);

    }


}
