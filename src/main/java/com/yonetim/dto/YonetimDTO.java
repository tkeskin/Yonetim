package com.yonetim.dto;

import javax.persistence.*;

@Entity
@Table(name = "yonetim")
public class YonetimDTO {

    //instance var.
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "ad")
    private String ad;
    @Column(name = "soyad")
    private String soyad;
    @Column(name = "aciklama")
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
