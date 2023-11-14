package com.ssafy.enjoytrip.board.model.dto;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BoardListDto {

    private List<BoardDto> articles;
    private int currentPage;
    private int totalPageCount;

}
