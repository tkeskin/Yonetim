package com.yonetim.dao;

import com.yonetim.dto.PlantDto;
import com.yonetim.dto.PlantList;
import com.yonetim.dto.SahipDto;
import com.yonetim.util.YonetimConst;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * tkeskin .
 */

@Component
public class SahipDao implements ISahipDao {

  @Autowired
  AgDao agDao;

  @Override
  public List<PlantDto> kayitAl(String arananKelime) throws Exception {
    Retrofit retrofit = new Retrofit.Builder()
        .baseUrl(YonetimConst.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build();
    IPlantDao plantDao = retrofit.create(IPlantDao.class);
    Call<PlantList> allPlants = plantDao.getAllPlants(arananKelime);
    Response<PlantList> execute = allPlants.execute();
    PlantList plantList = execute.body();
    return plantList.getPlants();
  }

  /**
   * @param arananKelime .
   * @return .
   * @throws Exception .
   */
  public List<SahipDto> kayitAlManuel(String arananKelime) throws Exception {
    List<SahipDto> sahipDtoList = new ArrayList<SahipDto>();
    String hamHali = agDao.istek(YonetimConst.URL);
    JSONObject outJson = new JSONObject(hamHali);
    JSONArray jsonArray = outJson.getJSONArray("plants");
    for (int i = 0; i < jsonArray.length(); i++) {
      JSONObject object = jsonArray.getJSONObject(i);
      SahipDto sahipDto = new SahipDto();
      int tc = object.getInt("id");
      String ad = object.getString("genus");
      String soyad = object.getString("species");

      sahipDto.setTc(tc);
      sahipDto.setAd(ad);
      sahipDto.setSoyad(soyad);

      //ekle
      sahipDtoList.add(sahipDto);
    }
    return sahipDtoList;
  }
}
