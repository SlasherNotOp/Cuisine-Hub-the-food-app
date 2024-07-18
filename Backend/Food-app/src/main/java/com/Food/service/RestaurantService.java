package com.Food.service;

import com.Food.dto.RestaurantDto;
import com.Food.entity.Restaurant;
import com.Food.entity.User;
import com.Food.request.CreateRetaurantRequest;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface RestaurantService {
    public Restaurant createRestaurant(CreateRetaurantRequest req, User user);

    public Restaurant updateRestaurant(Long restaurantId, CreateRetaurantRequest updateRestaurant)throws Exception;

    public void deleteRestaurant(Long restaurantId) throws Exception;

    public List<Restaurant>getAllRestaurant();

    public List<Restaurant>serachRestaurant(String keyword);

    public Restaurant findRestaurantById(Long id) throws Exception;

    public Restaurant getRestaurantByUserId(Long UserId)throws Exception;

    public RestaurantDto addToFavorites (Long restaurantId, User user) throws Exception;

    public Restaurant updateRestaurantStatus(Long id)throws Exception;






}
