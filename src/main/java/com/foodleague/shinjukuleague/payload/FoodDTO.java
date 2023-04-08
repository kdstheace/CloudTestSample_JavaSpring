package com.foodleague.shinjukuleague.payload;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class FoodDTO {
    private Long foodId;
    private String name;
    private BigDecimal price = BigDecimal.valueOf(0);
    private boolean isDel = false;
    private int winCnt = 0;
}
