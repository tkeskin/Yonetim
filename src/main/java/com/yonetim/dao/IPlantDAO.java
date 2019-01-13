package com.yonetim.dao;

import com.yonetim.dto.PlantList;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface IPlantDAO {
    @GET("/perl/mobile/viewplantsjson.pl")
    Call<PlantList> getAllPlants(@Query("Combined_Name") String cName);
}
