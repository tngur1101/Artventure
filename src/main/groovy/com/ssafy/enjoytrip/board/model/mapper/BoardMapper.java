package com.ssafy.enjoytrip.board.model.mapper;

import com.ssafy.enjoytrip.board.model.dto.BoardDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BoardMapper {

    void writeArticle(BoardDto boardDto);

    /*게시글 전체 조회*/
    List<BoardDto> selectAll(int type);

    /* 게시글 상세 조회 */
    BoardDto selectByArticleNo(@Param("type") int type,@Param("articleNo") String articleNo);

    /* 게시글 삭제 */
    void deleteArticle(String articleNo);

}
