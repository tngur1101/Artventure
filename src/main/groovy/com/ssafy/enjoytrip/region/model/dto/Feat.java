package com.ssafy.enjoytrip.region.model.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Feat {
    private int featId;
    private String name;
    private int regionId;
    private String description;
    private double latitude;
    private double longitude;
    private int order;
}
