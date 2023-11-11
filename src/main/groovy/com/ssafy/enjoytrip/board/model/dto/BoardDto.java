package com.ssafy.enjoytrip.board.model.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
public class BoardDto {

    private String articleNo;
    @NonNull private String title;
    @NonNull private String content;
    @NonNull private String author;
    private String writeDate;
    private String updateDate;
    @NonNull private int type;
    @NonNull private int regionId;

}
