package com.ssafy.enjoytrip.member.model.service;

import com.ssafy.enjoytrip.board.model.dto.BoardDto;
import com.ssafy.enjoytrip.board.model.dto.BoardListDto;
import com.ssafy.enjoytrip.board.model.mapper.BoardMapper;
import com.ssafy.enjoytrip.member.model.dto.MyInfo;
import com.ssafy.enjoytrip.member.model.mapper.MemberMapper;
import com.ssafy.enjoytrip.member.model.dto.MemberDto;
import com.ssafy.enjoytrip.region.model.dto.Complete;
import com.ssafy.enjoytrip.region.model.mapper.RegionMapper;
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
    private RegionMapper regionMapper;
    private BoardMapper boardMapper;

    @Override
    public List<MemberDto> selectAll() {
        return memberMapper.selectAll();
    }

    @Override
    public MemberDto selectUser(String id) {
        return memberMapper.selectUser(id);
    }

    @Override
    public MyInfo selectById(String id) {
        MyInfo myInfo = new MyInfo();
        HashMap<String, Object> completeMap = new HashMap<>();
        completeMap.put("userId", id);
        myInfo.setCompleteList(regionMapper.selectComplete(completeMap));

        Map<String, Object> articleMap = new HashMap<>();
        articleMap.put("key", "author");
        articleMap.put("content", id);
        int currentPage = 1;
        int sizePerPage = 10;
        int start = currentPage*sizePerPage-sizePerPage;

        articleMap.put("start", start);
        articleMap.put("spp", sizePerPage);

        List<BoardDto> list = boardMapper.listArticle(articleMap);
        myInfo.setArticles(list);

        System.out.println("!!!!!!!!!!!!!!!!!!myInfo : "+myInfo);
        return myInfo;
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