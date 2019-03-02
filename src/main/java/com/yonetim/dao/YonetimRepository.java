package com.yonetim.dao;

import com.yonetim.dto.YonetimDTO;
import org.springframework.data.repository.CrudRepository;

public interface YonetimRepository extends CrudRepository<YonetimDTO,Integer> {

}
