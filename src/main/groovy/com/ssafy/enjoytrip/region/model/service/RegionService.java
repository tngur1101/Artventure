package com.ssafy.enjoytrip.region.model.service;

import com.ssafy.enjoytrip.region.model.dto.Region;
import com.ssafy.enjoytrip.region.model.dto.Sido;

import java.util.List;
import java.util.Map;

public interface RegionService {
    List<Sido> selectAllSido();

    Region getRegion(Map<String, Object> data);

}
