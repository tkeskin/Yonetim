package com.yonetim.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PlantDTO {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("genus")
    @Expose
    private String genus;
    @SerializedName("species")
    @Expose
    private String species;
    @SerializedName("cultivar")
    @Expose
    private String cultivar;
    @SerializedName("common")
    @Expose
    private String common;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGenus() {
        return genus;
    }

    public void setGenus(String genus) {
        this.genus = genus;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getCultivar() {
        return cultivar;
    }

    public void setCultivar(String cultivar) {
        this.cultivar = cultivar;
    }

    public String getCommon() {
        return common;
    }

    public void setCommon(String common) {
        this.common = common;
    }

    @Override
    public String toString() {
        return id + " " + genus + " " + species + " " + cultivar + " " + common ;
    }
}
