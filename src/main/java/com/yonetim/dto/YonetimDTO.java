package com.yonetim.dto;

public class YonetimDTO {

    //instance var.
    private int id;
    private String ad;
    private String soyad;
    private String aciklama;

    //default cons.
    public YonetimDTO(){

    }

    //getter-setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    @Override
    public String toString() {
        return id + " " + ad + " " + soyad + " " + aciklama;
    }
}
