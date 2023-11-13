package com.ssafy.enjoytrip.member.controller;

import com.ssafy.enjoytrip.member.model.dto.MemberDto;
import com.ssafy.enjoytrip.member.model.service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/member")
@AllArgsConstructor
public class MemberController {
    private MemberService memberService;

    @GetMapping
    public ResponseEntity<List<MemberDto>> selectAll() {
        System.out.println("selectAll() 요청!!!!!");
        List<MemberDto> list = memberService.selectAll();
        System.out.println(list);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MemberDto> selectById(@PathVariable("id") String id) {
        System.out.println("검색 요청 아이디 : " + id);
        MemberDto memberDto = memberService.selectById(id);
        System.out.println("검색된 정보 : " + memberDto);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(memberDto);
    }

    
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody MemberDto member) {
        System.out.println("login 할 유저 : " + member);
        Map<String, Object> loginInfo = memberService.loginMember(member);
        if (loginInfo == null) return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        System.out.println("login 정보 : " + loginInfo);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(loginInfo);
    }

    @PostMapping
    public ResponseEntity<?> registUser(@RequestBody MemberDto member) {
        System.out.println("등록 할 유저 정보 : " + member);
        memberService.insertUser(member);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();
    }

    @PutMapping
    public ResponseEntity<?> updateUser(@RequestBody MemberDto member) {
        System.out.println("업데이트할 유저 정보 : " + member);
        memberService.updateUser(member);
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") String id) {
        System.out.println("삭제 요청 아이디 : " + id);
        memberService.deleteById(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }
}