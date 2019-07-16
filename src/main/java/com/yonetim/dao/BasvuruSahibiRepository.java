package com.yonetim.dao;

import com.yonetim.dto.BasvuruSahibiDto;
import java.util.Collection;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * tkeskin .
 */
public interface BasvuruSahibiRepository extends CrudRepository<BasvuruSahibiDto, Integer> {
  @Query(value = "SELECT * FROM basvuru_sahibi WHERE tc=:tckn ", nativeQuery = true)
  Collection<BasvuruSahibiDto> existsApplicant(@Param("tckn") String tckn);
}
