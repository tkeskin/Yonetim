package com.yonetim.dto;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * tkeskin .
 */
@Entity
@Table(name = "basvuruSahibi", uniqueConstraints = {
        @UniqueConstraint(columnNames = "TC")})
@SequenceGenerator(name = "seq_sahip", initialValue = 1, allocationSize = 100)
public class BasvuruSahibiDTO {
    //instance var.
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_sahip")
    @Column(name = "BASVURU_SAHIBI_ID", unique = true, nullable = false)
    private long id;
    @Column(name = "AD", unique = true, nullable = false, length = 20)
    private String ad;
    @Column(name = "SOYAD", unique = true, nullable = false, length = 20)
    private String soyad;
    @Column(name = "TC")
    private String tc;
    @Column(name = "CEP")
    private String cep;
    @Column(name = "EPOSTA")
    private String eposta;

    @OneToMany(
            mappedBy = "basvuruSahibiDTO",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<BasvuruDTO> basvuruDTOS = new ArrayList<>();

    public List<BasvuruDTO> getBasvuruDTOS() {
        return basvuruDTOS;
    }

    public void addBasvuru(BasvuruDTO basvuru) {
        basvuruDTOS.add(basvuru);
        basvuru.setBasvuruSahibiDTO(this);
    }

    public void removeComment(BasvuruDTO basvuru) {
        basvuruDTOS.remove(basvuru);
        basvuru.setBasvuruSahibiDTO(null);
    }

    public void setBasvuruDTOS(List<BasvuruDTO> basvuruDTOS) {
        this.basvuruDTOS = basvuruDTOS;
    }

    public String getTc() {
        return tc;
    }

    public void setTc(String tc) {
        this.tc = tc;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEposta() {
        return eposta;
    }

    public void setEposta(String eposta) {
        this.eposta = eposta;
    }

    //default cons.
    public BasvuruSahibiDTO() {

    }

    //getter-setter
    public long getId() {
        return id;
    }

    public void setId(long id) {
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
}
