package com.yonetim.dto;

import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * tkeskin .
 */
@Entity
@Table(name = "basvuru", uniqueConstraints = @UniqueConstraint(columnNames = "DATE"))
@SequenceGenerator(name = "seq_bas", initialValue = 1, allocationSize = 100)
public class BasvuruDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_bas")
    @Column(name = "BASVURU_ID", unique = true, nullable = false)
    private long id;
    @Column(name = "BASVURUTURU")
    private String basvuruTuru;
    @Column(name = "CEVAPTURU")
    private String cevapTuru;
    @Column(name = "ACIKLAMA")
    private String aciklama;
    @Column(name = "UNVAN")
    private String unvan;
    @CreationTimestamp
    @Column(name = "DATE", length = 10)
    private Date date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BASVURU_SAHIBI_ID")
    private BasvuruSahibiDTO basvuruSahibiDTO;

    public BasvuruSahibiDTO getBasvuruSahibiDTO() {
        return basvuruSahibiDTO;
    }

    public void setBasvuruSahibiDTO(BasvuruSahibiDTO basvuruSahibiDTO) {
        this.basvuruSahibiDTO = basvuruSahibiDTO;
    }

    public String getUnvan() {
        return unvan;
    }

    public void setUnvan(String unvan) {
        this.unvan = unvan;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBasvuruTuru() {
        return basvuruTuru;
    }

    public void setBasvuruTuru(String basvuruTuru) {
        this.basvuruTuru = basvuruTuru;
    }

    public String getCevapTuru() {
        return cevapTuru;
    }

    public void setCevapTuru(String cevapTuru) {
        this.cevapTuru = cevapTuru;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
