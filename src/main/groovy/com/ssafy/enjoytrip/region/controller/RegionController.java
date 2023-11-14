package com.ssafy.enjoytrip.region.controller;

import com.ssafy.enjoytrip.region.model.dto.Region;
import com.ssafy.enjoytrip.region.model.service.RegionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/region")
@RequiredArgsConstructor
public class RegionController {
    private final RegionService regionService;

    @GetMapping("/{regionId}")
    public ResponseEntity<?> getRegion(@RequestBody Map<String, Object> map, @PathVariable("regionId") int regionId) {
        System.out.println("요청 아이디 : " + map.get("userId") + ", 요청 지역 번호 : " + regionId);
        map.put("regionId", regionId);
        Region region = regionService.getRegion(map);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(region);
    }
}
