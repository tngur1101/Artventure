package com.ssafy.enjoytrip.member.model.dto;

import com.ssafy.enjoytrip.board.model.dto.BoardDto;
import com.ssafy.enjoytrip.board.model.dto.BoardListDto;
import com.ssafy.enjoytrip.region.model.dto.Complete;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MyInfo {
    private List<Complete> completeList;
    private List<BoardDto> articles;
}
