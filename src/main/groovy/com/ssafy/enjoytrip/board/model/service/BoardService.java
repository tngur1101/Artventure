package com.ssafy.enjoytrip.board.model.service;

import com.ssafy.enjoytrip.board.model.dto.BoardDto;

import java.util.List;

public interface BoardService {

    public void writeArticle(BoardDto boardDto);
    public List<BoardDto> selectAll(int type);
    public BoardDto selectByArticleNo(int type, String articleNo);
}
