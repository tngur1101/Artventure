package com.ssafy.enjoytrip.region.model.dto;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@ToString
public class Complete {
    private int featId;
    private String name;
    private String description;
    private String featTime;
    private double latitude;
    private double longitude;
}
