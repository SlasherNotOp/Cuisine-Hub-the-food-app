package com.Food.service;

import com.Food.dto.RestaurantDto;
import com.Food.entity.Address;
import com.Food.entity.Restaurant;
import com.Food.entity.User;
import com.Food.repository.AddressRepository;
import com.Food.repository.RestaurantRepository;
import com.Food.repository.UserRepository;
import com.Food.request.CreateRetaurantRequest;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class RestaurantServiceImp implements RestaurantService{

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private UserRepository userRepository;


    @Override
    public Restaurant createRestaurant(CreateRetaurantRequest req, User user) {
        Address address=addressRepository.save(req.getAddress());

        Restaurant restaurant=new Restaurant();

        restaurant.setAddress(address);
        restaurant.setContactInformation(req.getContactInformation());
        restaurant.setCuisineType(req.getCuisineType());
        restaurant.setDescription(req.getDescription());
        restaurant.setImages(req.getImages());
        restaurant.setName(req.getName());
        restaurant.setOpeningHours(req.getOpeningHours());
        restaurant.setRegistrationDate(LocalDateTime.now());
        restaurant.setOwner(user);


        return restaurantRepository.save(restaurant);
    }

    @Override
    public Restaurant updateRestaurant(Long restaurantId, CreateRetaurantRequest updateRestaurant) throws Exception {
        Restaurant restaurant=findRestaurantById(restaurantId);

        if(restaurant.getCuisineType()!=null){
            restaurant.setCuisineType(updateRestaurant.getCuisineType());
        }
        if(restaurant.getDescription()!=null){
            restaurant.setDescription(updateRestaurant.getDescription());
        }
        if(restaurant.getName()!=null){
            restaurant.setName(updateRestaurant.getName());
        }

        return restaurantRepository.save(restaurant);
    }

    @Override
    public void deleteRestaurant(Long restaurantId) throws Exception {
        Restaurant restaurant=findRestaurantById(restaurantId);

        restaurantRepository.delete(restaurant);
    }

    @Override
    public List<Restaurant> getAllRestaurant() {
        return restaurantRepository.findAll();

    }

    @Override
    public List<Restaurant> serachRestaurant(String keyword) {

        return restaurantRepository.findBySerachQuery(keyword);
    }

    @Override
    public Restaurant findRestaurantById(Long id) throws Exception {
        Optional<Restaurant>opt=restaurantRepository.findById(id);

        if(opt.isEmpty()){
            throw new Exception("restaurant not found with id"+id);
        }

        return opt.get();
    }

    @Override
    public Restaurant getRestaurantByUserId(Long UserId) throws Exception {

        Restaurant restaurant=restaurantRepository.findByOwnerId(UserId);
        if(restaurant==null){
            throw new Exception("restaurant not found with owner id"+UserId);
        }

        return restaurant;
    }

    @Override
    public RestaurantDto addToFavorites(Long restaurantId, User user) throws Exception {

        Restaurant restaurant=findRestaurantById(restaurantId);
        RestaurantDto dto=new RestaurantDto();
        dto.setDescription(restaurant.getDescription());
        dto.setImages(restaurant.getImages());
        dto.setTitle(restaurant.getName());
        dto.setId(restaurantId);

        if(user.getFavorites().contains(dto)){
            user.getFavorites().remove(dto);
        }else {
            user.getFavorites().add(dto);
        }
        userRepository.save(user);


        return dto;
    }

    @Override
    public Restaurant updateRestaurantStatus(Long id) throws Exception {
        Restaurant restaurant=findRestaurantById(id);
        restaurant.setOpen(!restaurant.isOpen());

        return restaurantRepository.save(restaurant);
    }
}
