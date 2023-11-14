package com.ssafy.enjoytrip.board.model.service;

import com.ssafy.enjoytrip.board.model.dto.BoardDto;
import com.ssafy.enjoytrip.board.model.dto.BoardListDto;

import java.util.List;
import java.util.Map;

public interface BoardService {

    public void writeArticle(BoardDto boardDto);
    public BoardListDto listArticle(Map<String, String> map);
    public BoardDto selectByArticleNo(int type, String articleNo);

    public void deleteArticle(String articleNo);

    public void updateArticle(BoardDto boardDto);

}
