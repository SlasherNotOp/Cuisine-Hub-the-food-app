package com.Food.request;

import lombok.Data;

@Data
public class IngredientItemRequest {

    private String name;

    private Long categoryId;

    private Long RestaurantId;
}
