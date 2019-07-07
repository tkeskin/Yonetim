package com.yonetim.dao;

import com.yonetim.dto.PlantDTO;
import com.yonetim.dto.PlantList;
import com.yonetim.dto.SahipDTO;
import com.yonetim.util.YonetimConst;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * tkeskin .
 */
@Component
public class SahipDAO implements ISahipDAO {

    @Autowired
    AgDAO agDAO;

    @Override
    public List<PlantDTO> kayitAl(String arananKelime) throws Exception {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(YonetimConst.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        IPlantDAO plantDAO = retrofit.create(IPlantDAO.class);
        Call<PlantList> allPlants = plantDAO.getAllPlants(arananKelime);
        Response<PlantList> execute = allPlants.execute();
        PlantList plantList = execute.body();
        return plantList.getPlants();
    }

    public List<SahipDTO> kayitAlManuel(String arananKelime) throws Exception {
        List<SahipDTO> sahipDTOList = new ArrayList<SahipDTO>();
        String hamHali = agDAO.istek(YonetimConst.URL);
        JSONObject outJson = new JSONObject(hamHali);
        JSONArray jsonArray = outJson.getJSONArray("plants");
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject object = jsonArray.getJSONObject(i);
            SahipDTO sahipDTO = new SahipDTO();
            int tc = object.getInt("id");
            String ad = object.getString("genus");
            String soyad = object.getString("species");

            sahipDTO.setTc(tc);
            sahipDTO.setAd(ad);
            sahipDTO.setSoyad(soyad);

            //ekle
            sahipDTOList.add(sahipDTO);
        }
        return sahipDTOList;
    }
}
