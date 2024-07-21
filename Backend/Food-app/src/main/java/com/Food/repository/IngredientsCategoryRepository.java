package com.Food.repository;

import com.Food.entity.IngredientsCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IngredientsCategoryRepository extends JpaRepository<IngredientsCategory,Long> {

    public List<IngredientsCategory>findByRestaurantId(Long id);

}
