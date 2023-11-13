package com.ssafy.enjoytrip.region.model.dto;


import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Region {
    private List<Complete> completeList;
    private List<Feat> featList;
}
