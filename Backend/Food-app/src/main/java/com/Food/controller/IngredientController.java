package com.Food.controller;

import com.Food.entity.IngredientsCategory;
import com.Food.entity.IngredientsItem;
import com.Food.request.IngredientCategoryRequest;
import com.Food.request.IngredientItemRequest;
import com.Food.service.IngredientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/ingredients")
public class IngredientController {

    @Autowired
    private IngredientsService ingredientsService;

    @PostMapping("/category")
    public ResponseEntity<IngredientsCategory>createIngredientsCategory(


            @RequestBody IngredientCategoryRequest request
            ) throws Exception {

        IngredientsCategory item=ingredientsService.createIngredientsCategory(request.getName(),request.getRestaurantId());

        return new ResponseEntity<>(item, HttpStatus.CREATED);
    }
    @PostMapping
    public ResponseEntity<IngredientsItem>createIngredientsItem(


            @RequestBody IngredientItemRequest request
    ) throws Exception {

        IngredientsItem item=ingredientsService.createIngredientsItem(request.getRestaurantId(), request.getName(), request.getCategoryId());

        return new ResponseEntity<>(item, HttpStatus.CREATED);
    }

    @PutMapping("{id}/stock")
    public ResponseEntity<IngredientsItem>updateIngredientStock(
            @PathVariable Long id

    ) throws Exception {

        IngredientsItem item=ingredientsService.updateStock(id);


        return new ResponseEntity<>(item, HttpStatus.OK);
    }

    @GetMapping("restaurant/{id}")
    public ResponseEntity<List<IngredientsItem>>getRestaurantIngredient(
            @PathVariable Long id
    ) throws Exception {

        List<IngredientsItem> items=ingredientsService.findRestaurantsIngredients(id);


        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    @GetMapping("restaurant/{id}/category")
    public ResponseEntity<List<IngredientsCategory>>getRestaurantIngredientCategory(
            @PathVariable Long id

    ) throws Exception {

        List<IngredientsCategory> items=ingredientsService.findIngredientsCategoryByRestaurantId(id);


        return new ResponseEntity<>(items, HttpStatus.OK);
    }




}
