package com.yonetim.dao;

import com.yonetim.dto.PlantList;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * tkeskin .
 */
public interface IPlantDAO {
    /**
     * @param cName .
     * @return .
     */
    @GET("/perl/mobile/viewplantsjson.pl")
    Call<PlantList> getAllPlants(@Query("Combined_Name") String cName);
}
