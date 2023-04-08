package com.foodleague.shinjukuleague.service;

import com.foodleague.shinjukuleague.entity.Food;
import com.foodleague.shinjukuleague.payload.FoodDTO;

import java.util.List;

public interface FoodService {
    FoodDTO registerFood(FoodDTO foodDTO);
    List<FoodDTO> getAllFood();
    FoodDTO getFoodById(Long id);
    FoodDTO overwriteFoodById(FoodDTO foodDTO, Long id);
    void deleteFoodById(Long id);
}
