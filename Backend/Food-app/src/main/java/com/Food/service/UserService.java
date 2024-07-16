package com.Food.service;


import com.Food.entity.User;

public interface UserService {
    public User findUserByJwtToken(String jwt)throws Exception;

    public User findUserByEmail(String email)throws Exception;
}
