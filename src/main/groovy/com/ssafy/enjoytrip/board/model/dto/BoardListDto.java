package com.ssafy.enjoytrip.board.model.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class BoardListDto {

    private List<BoardDto> articles;
    private int currentPage;
    private int totalPageCount;

}
