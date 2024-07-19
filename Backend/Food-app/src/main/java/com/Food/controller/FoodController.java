package com.Food.controller;

import com.Food.entity.Food;
import com.Food.entity.Restaurant;
import com.Food.entity.User;
import com.Food.request.CreateFoodRequest;
import com.Food.service.FoodService;
import com.Food.service.RestaurantService;
import com.Food.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/food")
public class FoodController {

    @Autowired
    private FoodService foodService;

    @Autowired
    private UserService userService;

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/search")
    public ResponseEntity<List<Food>> searchFood(@RequestParam String name,
                                           @RequestHeader("Authorization") String jwt
    ) throws Exception {
        User user=userService.findUserByJwtToken(jwt);

        List<Food> foods=foodService.searchFood(name);
        return new ResponseEntity<>(foods, HttpStatus.OK);
    }

    @GetMapping("/restaurant/{id}")
    public ResponseEntity<List<Food>> getRestaurantFood(
            @PathVariable long id,
            @RequestParam boolean vegetarian,
            @RequestParam boolean seasonal,
            @RequestParam boolean nonveg,
            @RequestParam(required = false) String food_category,
            @RequestHeader("Authorization") String jwt
    ) throws Exception {
        User user=userService.findUserByJwtToken(jwt);

        List<Food> foods=foodService.getRestaurantsFood(id,vegetarian,nonveg,seasonal,food_category);
        return new ResponseEntity<>(foods, HttpStatus.OK);
    }



}
