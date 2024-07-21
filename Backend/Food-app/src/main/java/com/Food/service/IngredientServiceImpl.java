package com.Food.service;

import com.Food.entity.IngredientsCategory;
import com.Food.entity.IngredientsItem;
import com.Food.entity.Restaurant;
import com.Food.repository.IngredientsCategoryRepository;
import com.Food.repository.IngredientsItemRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class IngredientServiceImpl implements IngredientsService{

    @Autowired
    private IngredientsItemRepository ingredientsItemRepository;

    @Autowired
    private IngredientsCategoryRepository ingredientsCategoryRepository;

    @Autowired
    private RestaurantService restaurantService;



    @Override
    public IngredientsCategory createIngredientsCategory(String name, Long restaurantId) throws Exception {
        Restaurant restaurant=restaurantService.findRestaurantById(restaurantId);

        IngredientsCategory category=new IngredientsCategory();
        category.setRestaurant(restaurant);
        category.setName(name);

        return ingredientsCategoryRepository.save(category);
    }

    @Override
    public IngredientsCategory findIngredientsCategoryById(Long id) throws Exception {

        Optional<IngredientsCategory>opt=ingredientsCategoryRepository.findById(id);
        if(opt.isEmpty()){
            throw new Exception("ingredient category not found");
        }

        return opt.get();
    }

    @Override
    public List<IngredientsCategory> findIngredientsCategoryByRestaurantId(Long id) throws Exception {
        restaurantService.findRestaurantById(id);

        return ingredientsCategoryRepository.findByRestaurantId(id);

    }

    @Override
    public IngredientsItem createIngredientsItem(Long restaurantId, String ingredientName, Long categoryId) throws Exception {
        Restaurant restaurant=restaurantService.findRestaurantById(restaurantId);

        IngredientsItem ingredientsItem=new IngredientsItem();

        IngredientsCategory ingredientsCategory=findIngredientsCategoryById(categoryId);

        ingredientsItem.setName(ingredientName);
        ingredientsItem.setRestaurant(restaurant);
        ingredientsItem.setCategory(ingredientsCategory);

        IngredientsItem ingredientsItem1= ingredientsItemRepository.save(ingredientsItem);

        ingredientsCategory.getIngredientsItems().add(ingredientsItem1);




        return ingredientsItem1;
    }

    @Override
    public List<IngredientsItem> findRestaurantsIngredients(Long restaurantId) {


        return ingredientsItemRepository.findByRestaurantId(restaurantId);
    }

    @Override
    public IngredientsItem updateStock(Long id) throws Exception {

        Optional<IngredientsItem>opt=ingredientsItemRepository.findById(id);

        if(opt.isEmpty()){
            throw new Exception("ingredient not found");
        }

        IngredientsItem ingredientsItem=opt.get();

        ingredientsItem.setInStock(!ingredientsItem.isInStock());


        return ingredientsItemRepository.save(ingredientsItem);
    }
}
