package com.Food.service;

import com.Food.entity.IngredientsCategory;
import com.Food.entity.IngredientsItem;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IngredientsService {
    public IngredientsCategory createIngredientsCategory(String name,Long restaurantId)throws Exception;

    public IngredientsCategory findIngredientsCategoryById(Long id)throws Exception;

    public List<IngredientsCategory>findIngredientsCategoryByRestaurantId(Long id)throws Exception;

    public IngredientsItem createIngredientsItem(Long restaurantId,String ingredientName, Long categoryId)throws Exception;


    public List<IngredientsItem>findRestaurantsIngredients(Long restaurantId);

    public IngredientsItem updateStock(Long id)throws Exception;





    

}
