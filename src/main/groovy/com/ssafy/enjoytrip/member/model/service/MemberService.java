package com.ssafy.enjoytrip.member.model.service;

import com.ssafy.enjoytrip.member.model.dto.MemberDto;
import com.ssafy.enjoytrip.member.model.dto.MyInfo;

import java.util.List;
import java.util.Map;

public interface MemberService {
    List<MemberDto> selectAll();
    MemberDto selectUser(String id);
    MyInfo selectById(String id);
    Map<String, Object> loginMember(MemberDto member);
    void insertUser(MemberDto member);
    void updateUser(MemberDto member);
    void deleteById(String id);

}
