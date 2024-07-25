package com.Food.service;

import com.Food.entity.*;
import com.Food.repository.*;
import com.Food.request.OrderReqeust;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderItemRepository orderItemRepository;

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private CartService cartService;

    @Override
    public Order crateOrder(OrderReqeust order, User user) throws Exception {

        Address address=order.getDeliveryAddress();

        Address savedAddress=addressRepository.save(address);

        if(!user.getAddresses().contains(savedAddress)){
            user.getAddresses().add(savedAddress);
            userRepository.save(user);
        }


        Restaurant restaurant=restaurantService.findRestaurantById(order.getRestaurantId());

        Order createdOrder=new Order();
        createdOrder.setCustomer(user);
        createdOrder.setCreatedAt(new Date());
        createdOrder.setOrderStatus("PENDING");
        createdOrder.setDeliveryAddress(savedAddress);
        createdOrder.setRestaurant(restaurant);

        Cart cart=cartService.findCartByUserId(user.getId());

        List<OrderItem>orderItems=new ArrayList<>();

        for(CartItem cartItem:cart.getItem()){
            OrderItem orderItem=new OrderItem();
            orderItem.setFood(cartItem.getFood());
            orderItem.setIngredients(cartItem.getIngredients());
            orderItem.setQuantity(cartItem.getQuantity());
            orderItem.setTotalPrice(cartItem.getTotalPrice());

            OrderItem savedOrderItem=orderItemRepository.save(orderItem);

            orderItems.add(savedOrderItem);

        }

        Long totalprice=cartService.calculateCartTotals(cart);

        createdOrder.setItmes(orderItems);
        createdOrder.setTotalPrice(totalprice);

        Order savedOrder=orderRepository.save(createdOrder);

        restaurant.getOrders().add(savedOrder);



        return savedOrder;
    }

    @Override
    public Order updateOrder(Long orderId, String orderStatus) throws Exception {

        Order order=findOrderById(orderId);
        if(orderStatus.equals("OUT_FOR_DELIVERY")||
                orderStatus.equals("DELIVERED")||
                orderStatus.equals("COMPLETED")||
                orderStatus.equals("PENDING")){
            order.setOrderStatus(orderStatus);

            return orderRepository.save(order);
        }

        throw new Exception("please select a valid order status");
    }

    @Override
    public void cancelOrder(long orderId) throws Exception {

        Order order=findOrderById(orderId);

        orderRepository.deleteById(orderId);

    }

    @Override
    public List<Order> getUsersOrder(long userId) throws Exception {



        return orderRepository.findByCustomerId(userId);
    }

    @Override
    public List<Order> getRestaurantsOrder(long restaurantId, String orderStatus) throws Exception {


        List<Order>orders=orderRepository.findByRestaurantId(restaurantId);
        if(orderStatus!=null){
            orders=orders.stream().filter(order->
                    order.getOrderStatus().equals(orderStatus)).collect(Collectors.toList());
        }


        return orders;
    }

    @Override
    public Order findOrderById(long orderId) throws Exception {

        Optional<Order> optional=orderRepository.findById(orderId);


        if(optional.isEmpty()){
            throw new Exception("order not found with this id");
        }

        return optional.get();
    }


}
