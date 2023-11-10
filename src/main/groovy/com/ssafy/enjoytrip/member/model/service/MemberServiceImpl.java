package com.ssafy.enjoytrip.member.model.service;

import com.ssafy.enjoytrip.member.model.mapper.MemberMapper;
import com.ssafy.enjoytrip.member.model.dto.MemberDto;
import com.ssafy.enjoytrip.util.JWTUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Override
    public Map<String, Object> loginMember(MemberDto member) {
        MemberDto loginUser = memberMapper.loginMember(member);
        if (loginUser == null) return null;
        Map<String, Object> tokenResponse = new HashMap<>();
        String token = JWTUtil.generateToken(loginUser);
        tokenResponse.put("token", token);
        return tokenResponse;
    }


    @Override
    public void insertUser(MemberDto member) {
        memberMapper.insertUser(member);
    }

    @Override
    public void updateUser(MemberDto member) {
        memberMapper.updateUser(member);
    }

    @Override
    public void deleteById(String id) {
        memberMapper.deleteById(id);
    }
}