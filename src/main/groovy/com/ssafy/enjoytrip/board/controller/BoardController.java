package com.ssafy.enjoytrip.board.controller;

import com.ssafy.enjoytrip.board.model.dto.BoardDto;
import com.ssafy.enjoytrip.board.model.dto.BoardListDto;
import com.ssafy.enjoytrip.board.model.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


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

    //  http://localhost:80/board/1
    // http://localhost:80/board?type=1&pgno=3
    // http://localhost:80/board?regionid=3
    @GetMapping
    public ResponseEntity<BoardListDto> selectAll(@RequestParam Map<String, String> map){
        System.out.println(map);
        BoardListDto boardListDto = boardService.listArticle(map);

        return ResponseEntity.ok().body(boardListDto);
    }

    @GetMapping("/{articleNo}")
    public ResponseEntity<BoardDto> selectByArticleNo(@PathVariable String articleNo){
        BoardDto board = boardService.selectByArticleNo(articleNo);
        return ResponseEntity.status(HttpStatus.OK).body(board);
    }

    @DeleteMapping("/{articleNo}")
    public ResponseEntity<?> deleteArticle(@PathVariable String articleNo){
        boardService.deleteArticle(articleNo);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    /*수정 할 글 얻기*/
    @GetMapping("/modify/{articleNo}")
    public ResponseEntity<BoardDto> getModifyArticle(@PathVariable String articleNo){
        BoardDto board = boardService.selectByArticleNo(articleNo);
        return ResponseEntity.status(HttpStatus.OK).body(board);
    }


    /*글 수정*/
    @PutMapping
    public ResponseEntity<?> updateArticle(@RequestBody BoardDto boardDto){
        boardService.updateArticle(boardDto);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
