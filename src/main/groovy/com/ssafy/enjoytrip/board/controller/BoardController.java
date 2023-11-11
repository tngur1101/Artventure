package com.ssafy.enjoytrip.board.controller;

import com.ssafy.enjoytrip.board.model.dto.BoardDto;
import com.ssafy.enjoytrip.board.model.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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

}
