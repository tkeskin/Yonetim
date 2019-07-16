package com.yonetim.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * tkeskin .
 */

public class PlantList {

  @SerializedName("plants")
  @Expose
  private List<PlantDto> plants = null;

  public List<PlantDto> getPlants() {
    return plants;
  }

  public void setPlants(List<PlantDto> plants) {
    this.plants = plants;
  }
}