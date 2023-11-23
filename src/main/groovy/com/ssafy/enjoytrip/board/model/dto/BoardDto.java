package com.ssafy.enjoytrip.board.model.dto;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
public class BoardDto {

    private int articleNo;
    @NonNull private String title;
    @NonNull private String content;
    @NonNull private String author;
    private String writeDate;
    private String updateDate;
    @NonNull private int type;
    @NonNull private int regionId;
    private MultipartFile[] files;
    private List<String> imageUrl;
}
