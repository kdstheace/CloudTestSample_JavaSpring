package com.foodleague.shinjukuleague.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.foodleague.shinjukuleague.payload.FoodDTO;
import com.foodleague.shinjukuleague.service.FoodService;

import java.util.List;

@RestController
@RequestMapping("/api/foods")
public class FoodController {
    private FoodService foodService;

    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    //@Daniel create food api
    @PostMapping
    public ResponseEntity<FoodDTO> createFood(@RequestBody FoodDTO foodDTO){
        return new ResponseEntity<>(foodService.registerFood(foodDTO), HttpStatus.CREATED);
    }

    //@Daniel get all food api
    @GetMapping
    public List<FoodDTO> getAllFood(){
        //Daniel: Specify the response status, otherwise it will be 200 OK by default
        return foodService.getAllFood();
    }

    //@Daniel get food by id
    @GetMapping("/{id}")
    public ResponseEntity<FoodDTO> getFoodById(@PathVariable(name="id") Long id){
        return ResponseEntity.ok(foodService.getFoodById(id));
    }

    //@Daniel overwrite food by id
    @PutMapping("/{id}")
    public ResponseEntity<FoodDTO> overwriteFoodById(@PathVariable(name="id")Long id, @RequestBody FoodDTO foodDTO){
        return ResponseEntity.ok(foodService.overwriteFoodById(foodDTO, id));
    }

    //@Daniel delete food by id
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFoodById(@PathVariable(name="id")Long id){
        foodService.deleteFoodById(id);
        return ResponseEntity.ok("Post entity has benn delete successfully");
    }
}
