package com.ssafy.enjoytrip.board.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class FileInfoDto {

    private String saveFolder;  //저장폴더
    private String originalFile;    //원본 파일 이름
    private String saveFile;    //저장 파일이름

}
