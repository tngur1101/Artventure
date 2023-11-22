package com.ssafy.enjoytrip.member.model.dto;

import com.ssafy.enjoytrip.region.model.dto.Complete;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@RequiredArgsConstructor
public class MemberDto {
    @NonNull
    private String id;
    @NonNull
    private String password;
    @NonNull
    private String name;
    @NonNull
    private String nickname;
    private String joindate;
    private boolean admin;
    private int deleted;
    private List<Complete> completeList;
}