package com.ssafy.enjoytrip.board.model.mapper;

import com.ssafy.enjoytrip.board.model.dto.BoardDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface BoardMapper {

//    void writeArticle(BoardDto boardDto);
    void writeArticle(BoardDto boardDto);

    /*게시글 전체 조회*/
    List<BoardDto> listArticle(Map<String, Object> map);

    /* 게시글 상세 조회 */
    BoardDto selectByArticleNo(int articleNo);

    /* 게시글 삭제 */
    void deleteArticle(int articleNo);

    /* 게시글 수정 */
    void updateArticle(BoardDto boardDto);

    int getTotalArticleCount(Map<String, Object> param);

//    void registerFile(BoardDto boardDto);
    void registerFile(Map<String, Object> map);

}
