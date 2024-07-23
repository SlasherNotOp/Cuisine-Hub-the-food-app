package com.Food.repository;

import com.Food.entity.IngredientsItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredientsItemRepository extends JpaRepository<IngredientsItem,Long> {
    List<IngredientsItem>findByRestaurantId(Long id);

}