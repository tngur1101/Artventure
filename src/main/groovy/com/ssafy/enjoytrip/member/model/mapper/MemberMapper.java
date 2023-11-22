package com.ssafy.enjoytrip.member.model.mapper;

import com.ssafy.enjoytrip.board.model.dto.BoardListDto;
import com.ssafy.enjoytrip.member.model.dto.MemberDto;
import com.ssafy.enjoytrip.region.model.dto.Complete;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {
    List<MemberDto> selectAll();
    List<Complete> selectCompleteById(String id);
    MemberDto selectUser(String id);

    BoardListDto selectArticleById(String id);

    MemberDto loginMember(MemberDto member);
    void insertUser(MemberDto member);
    void updateUser(MemberDto member);
    void deleteById(String id);
}
