package com.ssafy.enjoytrip.member.model.service;

import com.ssafy.enjoytrip.mapper.MemberMapper;
import com.ssafy.enjoytrip.member.model.dto.MemberDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MemberServiceImpl implements MemberService {
    private MemberMapper memberMapper;


    @Override
    public List<MemberDto> selectAll() {
        return memberMapper.selectAll();
    }

    @Override
    public MemberDto selectById(String id) {
        return memberMapper.selectById(id);
    }
}