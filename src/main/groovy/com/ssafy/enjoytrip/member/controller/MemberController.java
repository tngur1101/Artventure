package com.ssafy.enjoytrip.member.controller;

import com.ssafy.enjoytrip.member.model.dto.MemberDto;
import com.ssafy.enjoytrip.member.model.service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class MemberController {
    private MemberService memberService;

    @GetMapping
    public ResponseEntity<?> selectAll() {
        System.out.println("selectAll() 요청!!!!!");
        List<MemberDto> list = memberService.selectAll();
        System.out.println(list);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> selectById(@PathVariable("id") String id) {
        System.out.println("검색 요청 아이디 : " + id);
        MemberDto memberDto = memberService.selectById(id);
        System.out.println("검색된 정보 : " + memberDto);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(memberDto);
    }
}