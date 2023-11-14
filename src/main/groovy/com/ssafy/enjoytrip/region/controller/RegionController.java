package com.ssafy.enjoytrip.region.controller;

import com.ssafy.enjoytrip.region.model.dto.Region;
import com.ssafy.enjoytrip.region.model.dto.Sido;
import com.ssafy.enjoytrip.region.model.service.RegionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/region")
@RequiredArgsConstructor
public class RegionController {
    private final RegionService regionService;

    @GetMapping
    public ResponseEntity<?> getAllRegion() {
        System.out.println("모든 시도 정보 요청");
        List<Sido> sidoList = regionService.selectAllSido();
        System.out.println("시도 정보 : " + sidoList);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(sidoList);
    }

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
