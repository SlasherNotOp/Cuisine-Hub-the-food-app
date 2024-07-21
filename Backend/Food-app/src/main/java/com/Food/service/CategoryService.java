package com.Food.service;

import com.Food.entity.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
    public Category createCategory(String name,Long userId) throws Exception;

    public List<Category>findCategoryByRestaurantId(Long id)throws Exception;

    public Category findCategoryById(long id)throws Exception;


}
