package com.ssafy.enjoytrip.board.controller;

import com.ssafy.enjoytrip.board.model.dto.BoardDto;
import com.ssafy.enjoytrip.board.model.dto.BoardListDto;
import com.ssafy.enjoytrip.board.model.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @PostMapping
    public ResponseEntity<?> writeArticle(@ModelAttribute BoardDto boardDto) throws Exception {
        System.out.println("컨트롤러에서 찍는 boardDto"+boardDto.toString());
        boardService.writeArticle(boardDto);
//        for(FileInfoDto f: boardDto.getFileInfos()){
//            boardService.saveImage(f.getOriginFile());
//        }

        boardService.saveImage(boardDto.getFiles(), boardDto);

//        boardService.saveImage(boardDto.getFiles()[0]);
//        boardService.writeArticle(map);
//        boardService.saveImage(file[0]);
//        System.out.println("file: "+file);
//        System.out.println("map:"+map);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    //  http://localhost:80/board/1
    // http://localhost:80/board?type=1&pgno=3
    // http://localhost:80/board?regionid=3
    @GetMapping
    public ResponseEntity<BoardListDto> selectAll(@RequestParam Map<String, String> map){
        System.out.println("input param : "+map);
        BoardListDto boardListDto = boardService.listArticle(map);

        return ResponseEntity.ok().body(boardListDto);
    }

    @GetMapping("/{articleNo}")
    public ResponseEntity<BoardDto> selectByArticleNo(@PathVariable int articleNo){
        BoardDto board = boardService.selectByArticleNo(articleNo);
        return ResponseEntity.status(HttpStatus.OK).body(board);
    }

    @DeleteMapping("/{articleNo}")
    public ResponseEntity<?> deleteArticle(@PathVariable int articleNo){
        boardService.deleteArticle(articleNo);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    /*수정 할 글 얻기*/
    @GetMapping("/modify/{articleNo}")
    public ResponseEntity<BoardDto> getModifyArticle(@PathVariable int articleNo){
        BoardDto board = boardService.selectByArticleNo(articleNo);
        return ResponseEntity.status(HttpStatus.OK).body(board);
    }


    /*글 수정*/
    @PutMapping
    public ResponseEntity<?> updateArticle(@RequestBody BoardDto boardDto){
        boardService.updateArticle(boardDto);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

//    @ResponseBody
//    @GetMapping("/images/{filename}")
//    public Resource showImage(@PathVariable String filename) throws MalformedURLException {
//        return new UrlResource("file:"+file.getFullPath(filename));
//    }

}
