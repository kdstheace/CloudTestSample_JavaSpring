package com.foodleague.shinjukuleague.payload;

import lombok.Data;

@Data
public class LeagueDTO {
    private Long leagueId;
    private String title;
    private String createdBy;
    private int viewCnt;
}
