package com.ssafy.enjoytrip.mapper;

import com.ssafy.enjoytrip.member.model.dto.MemberDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {
    public List<MemberDto> selectAll();
    public MemberDto selectById(String id);
    public MemberDto loginMember(MemberDto member);

    public void insertUser(MemberDto member);
    public void updateUser(MemberDto member);
    public void deleteById(String id);
}
