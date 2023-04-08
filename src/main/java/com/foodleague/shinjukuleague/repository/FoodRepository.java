package com.foodleague.shinjukuleague.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foodleague.shinjukuleague.entity.Food;

public interface FoodRepository extends JpaRepository<Food, Long> {

}
