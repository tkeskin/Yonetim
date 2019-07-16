package com.yonetim.dto;

/**
 * tkeskin .
 */

public class SahipDto {

  //instance var.
  private int tc;
  private String ad;
  private String soyad;

  //default cons.
  public SahipDto() {

  }

  public int getTc() {
    return tc;
  }

  public void setTc(int tc) {
    this.tc = tc;
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

  @Override
  public String toString() {
    return tc + " " + ad + " " + soyad;
  }
}
