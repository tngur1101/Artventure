package com.ssafy.enjoytrip.board.model.service;

import com.ssafy.enjoytrip.board.model.dto.BoardDto;
import com.ssafy.enjoytrip.board.model.dto.BoardListDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

public interface BoardService {

//    public void writeArticle(BoardDto boardDto);
    public void writeArticle(BoardDto boardDto);

    public void saveImage(MultipartFile[] file, BoardDto boardDto) throws Exception;
    public BoardListDto listArticle(Map<String, String> map);
    public BoardDto selectByArticleNo(int articleNo);

    public void deleteArticle(int articleNo);

    public void updateArticle(BoardDto boardDto);

}
