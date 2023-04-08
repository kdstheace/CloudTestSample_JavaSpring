package com.foodleague.shinjukuleague.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.foodleague.shinjukuleague.entity.Food;
import com.foodleague.shinjukuleague.exception.ResourceNotFoundException;
import com.foodleague.shinjukuleague.payload.FoodDTO;
import com.foodleague.shinjukuleague.repository.FoodRepository;
import com.foodleague.shinjukuleague.service.FoodService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FoodServiceImpl implements FoodService {
    private FoodRepository foodRepository;
    private ModelMapper mapper;

    public FoodServiceImpl(FoodRepository foodRepository, ModelMapper mapper) {
        this.foodRepository = foodRepository;
        this.mapper = mapper;
    }

    //@Daniel: register food
    @Override
    public FoodDTO registerFood(FoodDTO foodDTO) {
        Food food = mapToEntity(foodDTO);
        Food savedFood = foodRepository.save(food);

        return mapToDTO(savedFood);
    }

    //@Daniel: get all food
    @Override
    public List<FoodDTO> getAllFood() {
        List<Food> savedFoodList = foodRepository.findAll();
        return savedFoodList.stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public FoodDTO getFoodById(Long id) {
        Food food = foodRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Food", "id", id.toString()));
        return mapToDTO(food);
    }

    @Override
    public FoodDTO overwriteFoodById(FoodDTO foodDTO, Long id) {
        //get food by id
        Food food = foodRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Food", "id", id.toString()));
        food.setName(foodDTO.getName());
        food.setPrice(foodDTO.getPrice());
        food.setWinCnt(foodDTO.getWinCnt());
        return mapToDTO(foodRepository.save(food));
    }

    @Override
    public void deleteFoodById(Long id) {
        //get food by id
        Food food = foodRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Food", "id", id.toString()));
        foodRepository.delete(food);

    }
    //@Daniel: In case we do not use ModelMapper library, better use getter/setter or additional common functions
    private FoodDTO mapToDTO(Food food){
        return mapper.map(food, FoodDTO.class);
    }

    private Food mapToEntity(FoodDTO foodDTO){
        return mapper.map(foodDTO, Food.class);
    }

}
