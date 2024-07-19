package com.Food.controller;

import com.Food.entity.Food;
import com.Food.entity.Restaurant;
import com.Food.entity.User;
import com.Food.request.CreateFoodRequest;
import com.Food.response.MessageResponse;
import com.Food.service.FoodService;
import com.Food.service.RestaurantService;
import com.Food.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/admin/food")
public class AdminFoodController {
    @Autowired
    private FoodService foodService;

    @Autowired
    private UserService userService;

    @Autowired
    private RestaurantService restaurantService;

    @PostMapping
    public ResponseEntity<Food>createFood(@RequestBody CreateFoodRequest req,
                                          @RequestHeader("Authorization") String jwt
                                          ) throws Exception {
        User user=userService.findUserByJwtToken(jwt);

        Restaurant restaurant=restaurantService.findRestaurantById(req.getRestaurantId());
        Food food=foodService.createFood(req,req.getCategory(),restaurant);
        return new ResponseEntity<>(food, HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<MessageResponse>deleteFood(@PathVariable long id,
                                                     @RequestHeader("Authorization") String jwt
    ) throws Exception {
        User user=userService.findUserByJwtToken(jwt);

      foodService.deleteFood(id);

      MessageResponse res=new MessageResponse();
      res.setMessage("food deleted successfully");

        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Food>updateFoodAvaibalityStatus
            (@PathVariable long id,
             @RequestHeader("Authorization") String jwt
    ) throws Exception {
        User user=userService.findUserByJwtToken(jwt);

        Food food= foodService.updateAvalability(id);



        return new ResponseEntity<>(food, HttpStatus.CREATED);
    }
}
