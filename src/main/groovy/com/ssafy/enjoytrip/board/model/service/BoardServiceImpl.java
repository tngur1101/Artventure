package com.ssafy.enjoytrip.board.model.service;

import com.ssafy.enjoytrip.board.model.dto.BoardDto;
import com.ssafy.enjoytrip.board.model.dto.BoardListDto;
import com.ssafy.enjoytrip.board.model.dto.FileInfoDto;
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

        //이미지 파일 등록하는 부분 -> 추후 프론트 생성 후 확인 필요!
        List<FileInfoDto> fileInfos = boardDto.getFileInfos();
        if(fileInfos != null && !fileInfos.isEmpty()){
            boardMapper.registerFile(boardDto);
        }
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
    public BoardDto selectByArticleNo(String articleNo) {
        return boardMapper.selectByArticleNo(articleNo);
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
