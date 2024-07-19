package com.Food.service;

import com.Food.entity.Category;
import com.Food.entity.Food;
import com.Food.entity.Restaurant;
import com.Food.request.CreateFoodRequest;
import com.Food.request.CreateRetaurantRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FoodService {
    public Food createFood(CreateFoodRequest req, Category category, Restaurant restaurant);
    public void deleteFood(Long foodId)throws Exception;

    public List<Food>getRestaurantsFood(long RestaurantId,boolean isVegetarian,
                                        boolean isNonveg,boolean isSeasional,
                                        String foodCategory);

    public List<Food>searchFood(String keyword);

    public Food findFoodById(Long foodId) throws Exception;

    public Food updateAvalability(Long foodId)throws Exception;




}
