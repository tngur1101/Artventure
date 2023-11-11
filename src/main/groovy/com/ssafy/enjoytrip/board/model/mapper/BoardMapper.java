package com.ssafy.enjoytrip.board.model.mapper;

import com.ssafy.enjoytrip.board.model.dto.BoardDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {

    void writeArticle(BoardDto boardDto);

    /*게시글 전체 조회*/
    List<BoardDto> selectAll(String type);


}
