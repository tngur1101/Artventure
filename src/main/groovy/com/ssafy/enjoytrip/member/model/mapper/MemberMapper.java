package com.ssafy.enjoytrip.member.model.mapper;

import com.ssafy.enjoytrip.member.model.dto.MemberDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {
    List<MemberDto> selectAll();
    MemberDto selectById(String id);
    MemberDto loginMember(MemberDto member);
    void insertUser(MemberDto member);
    void updateUser(MemberDto member);
    void deleteById(String id);
}
