package com.Food.response;

import com.Food.entity.USER_ROLE;
import lombok.Data;

@Data
public class AuthResponse {
    private String jwt;

    private String message;

    private USER_ROLE role;
}
