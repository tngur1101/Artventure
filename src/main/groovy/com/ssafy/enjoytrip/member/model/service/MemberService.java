package com.ssafy.enjoytrip.member.model.service;

import com.ssafy.enjoytrip.member.model.dto.MemberDto;

import java.util.List;

public interface MemberService {
    public List<MemberDto> selectAll();
    public MemberDto selectById(String id);
}
