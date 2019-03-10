package com.yonetim.dao;

import com.yonetim.dto.BasvuruSahibiDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface BasvuruSahibiRepository extends CrudRepository<BasvuruSahibiDTO,Integer> {
    @Query(value = "SELECT * FROM basvuru_sahibi WHERE tc=:name ", nativeQuery = true)
    Collection<BasvuruSahibiDTO> existsApplicant(@Param("name") String name);
}
