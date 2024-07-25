package com.Food.service;

import com.Food.entity.Order;
import com.Food.entity.User;
import com.Food.request.OrderReqeust;

import java.util.List;

public interface OrderService {

    public Order crateOrder(OrderReqeust order, User user) throws Exception;

    public Order updateOrder(Long orderId,String orderStatus) throws Exception;

    public void cancelOrder(long orderId)throws Exception;

    public List<Order>getUsersOrder(long userId)throws Exception;

    public List<Order>getRestaurantsOrder(long restaurantId,String orderStatus)throws Exception;

    public Order findOrderById(long orderId)throws Exception;



}
