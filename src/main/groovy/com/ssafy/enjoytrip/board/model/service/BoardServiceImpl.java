package com.ssafy.enjoytrip.board.model.service;

import com.ssafy.enjoytrip.board.model.dto.BoardDto;
import com.ssafy.enjoytrip.board.model.dto.BoardListDto;
import com.ssafy.enjoytrip.board.model.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{

    private final BoardMapper boardMapper;
    @Override
    public void writeArticle(BoardDto boardDto) {
        boardMapper.writeArticle(boardDto);
    }

    @Override
    public BoardListDto listArticle(Map<String, String> map) {
        Map<String, Object> param = new HashMap<String, Object>();

        param.put("type", map.get("type")==null?"":map.get("type"));
        param.put("word", map.get("word")==null?"":map.get("word"));
        int currentPage = Integer.parseInt(map.get("pgno")==null?"1":map.get("pgno"));
        int sizePerPage = Integer.parseInt(map.get("spp")==null?"10":map.get("spp"));

        int start = currentPage*sizePerPage-sizePerPage;

        param.put("start", start);

        String key = map.get("key");
        param.put("key", key==null?"":key);

        List<BoardDto> list = boardMapper.listArticle(param);

        int totalArticleCount = boardMapper.getTotalArticleCount(param);
        int totalPageCount = (totalArticleCount-1)/sizePerPage+1;

        BoardListDto boardListDto = new BoardListDto();
        boardListDto.setArticles(list);
        boardListDto.setCurrentPage(currentPage);
        boardListDto.setTotalPageCount(totalPageCount);

        return boardListDto;
    }

    @Override
    public BoardDto selectByArticleNo(int type, String articleNo) {
        return boardMapper.selectByArticleNo(type, articleNo);
    }

    @Override
    public void deleteArticle(String articleNo) {
        boardMapper.deleteArticle(articleNo);
    }

    @Override
    public void updateArticle(BoardDto boardDto) {
        boardMapper.updateArticle(boardDto);
    }


}
