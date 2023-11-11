package com.ssafy.enjoytrip.board.controller;

import com.ssafy.enjoytrip.board.model.dto.BoardDto;
import com.ssafy.enjoytrip.board.model.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @PostMapping
    public ResponseEntity<?> writeArticle(@RequestBody BoardDto boardDto){
        boardService.writeArticle(boardDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{type}")
    public ResponseEntity<List<BoardDto>> selectAll(@PathVariable int type){
        List<BoardDto> list = boardService.selectAll(type);
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @GetMapping("/{type}/{articleNo}")
    public ResponseEntity<BoardDto> selectByArticleNo(@PathVariable("type") int type,@PathVariable("articleNo") String articleNo){
        BoardDto board = boardService.selectByArticleNo(type, articleNo);
        return ResponseEntity.status(HttpStatus.OK).body(board);
    }


}
