package com.Food.request;

import com.Food.entity.Address;
import lombok.Data;

@Data
public class OrderReqeust {
    private long restaurantId;
    private Address deliveryAddress;
}
