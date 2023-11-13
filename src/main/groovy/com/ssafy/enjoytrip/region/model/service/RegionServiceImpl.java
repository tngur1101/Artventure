package com.ssafy.enjoytrip.region.model.service;

import com.ssafy.enjoytrip.region.model.dto.Region;
import com.ssafy.enjoytrip.region.model.mapper.RegionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class RegionServiceImpl implements RegionService {
    private final RegionMapper regionMapper;
    @Override
    public Region getRegion(Map<String, Object> data) {
        Region region = new Region();
        int regionId = (int) data.get("regionId");
        System.out.println(data);
        region.setCompleteList(regionMapper.selectComplete(data));
        region.setFeatList(regionMapper.selectFeat(regionId));
        return region;
    }
}
