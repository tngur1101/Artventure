package com.ssafy.enjoytrip.region.model.mapper;

import com.ssafy.enjoytrip.region.model.dto.Complete;
import com.ssafy.enjoytrip.region.model.dto.Feat;
import com.ssafy.enjoytrip.region.model.dto.Region;
import com.ssafy.enjoytrip.region.model.dto.Sido;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface RegionMapper {
    List<Sido> selectAllSido();
    List<Feat> selectFeat(int regionId);
    List<Complete> selectComplete(Map<String, Object> data);
}
