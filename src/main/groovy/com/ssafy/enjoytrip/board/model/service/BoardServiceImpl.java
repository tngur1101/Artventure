package com.ssafy.enjoytrip.board.model.service;

import com.ssafy.enjoytrip.board.model.dto.BoardDto;
import com.ssafy.enjoytrip.board.model.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{

    private final BoardMapper boardMapper;
    @Override
    public void writeArticle(BoardDto boardDto) {
        boardMapper.writeArticle(boardDto);
    }

    @Override
    public List<BoardDto> selectAll(String type) {
        return boardMapper.selectAll(type);
    }

    @Override
    public BoardDto selectByArticleNo(String type, String articleNo) {
        return boardMapper.selectByArticleNo(type, articleNo);
    }


}
