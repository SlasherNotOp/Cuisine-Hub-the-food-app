package com.Food.controller;

import com.Food.entity.CartItem;
import com.Food.entity.Order;
import com.Food.entity.User;
import com.Food.request.AddCartItemRequest;
import com.Food.request.OrderReqeust;
import com.Food.service.OrderService;
import com.Food.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    @PostMapping("/order")
    public ResponseEntity<Order> CreateOrder(@RequestBody OrderReqeust req,
                                                  @RequestHeader("Authorization") String jwt
    ) throws Exception {

        User user=userService.findUserByJwtToken(jwt);

        Order order=orderService.crateOrder(req,user);

        return new ResponseEntity<>(order, HttpStatus.CREATED);
    }

    @GetMapping("/order/user")
    public ResponseEntity<List<Order>> getOrderHistory(
                                             @RequestHeader("Authorization") String jwt
    ) throws Exception {

        User user=userService.findUserByJwtToken(jwt);

        List<Order>orders=orderService.getUsersOrder(user.getId());

        return new ResponseEntity<>(orders, HttpStatus.OK);
    }





}
