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
public class BasvuruSahibiDto {
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
      mappedBy = "basvuruSahibiDto",
      cascade = CascadeType.ALL,
      orphanRemoval = true
  )
  private List<BasvuruDto> basvuruDtos = new ArrayList<>();

  public List<BasvuruDto> getBasvuruDtos() {
    return basvuruDtos;
  }

  public void addBasvuru(BasvuruDto basvuru) {
    basvuruDtos.add(basvuru);
    basvuru.setBasvuruSahibiDto(this);
  }

  public void removeComment(BasvuruDto basvuru) {
    basvuruDtos.remove(basvuru);
    basvuru.setBasvuruSahibiDto(null);
  }

  public void setBasvuruDtos(List<BasvuruDto> basvuruDtos) {
    this.basvuruDtos = basvuruDtos;
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
  public BasvuruSahibiDto() {

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
