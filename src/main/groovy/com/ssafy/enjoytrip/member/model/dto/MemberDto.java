package com.ssafy.enjoytrip.member.model.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MemberDto {
    private String id;
    private String password;
    private String name;
    private String nickname;
    private String joindate;
    private boolean admin;
    private int deleted;
}
