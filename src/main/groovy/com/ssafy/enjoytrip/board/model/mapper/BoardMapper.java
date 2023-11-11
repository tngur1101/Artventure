package com.ssafy.enjoytrip.board.model.mapper;

import com.ssafy.enjoytrip.board.model.dto.BoardDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {

    void writeArticle(BoardDto boardDto);

    /*공지 글 전체 조회*/
    List<BoardDto> selectNotifications();

    /*공략글 전체 조회*/

    /*건의 글 전체 조회*/


}
