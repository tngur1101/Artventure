package com.ssafy.enjoytrip.member.model.service;

import com.ssafy.enjoytrip.member.model.dto.MemberDto;

import java.util.List;
import java.util.Map;

public interface MemberService {
    public List<MemberDto> selectAll();
    public MemberDto selectById(String id);
    public Map<String, Object> loginMember(MemberDto member);
    public void insertUser(MemberDto member);
    public void updateUser(MemberDto member);
    public void deleteById(String id);
}
