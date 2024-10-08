package com.Food.service;

import com.Food.config.JwtProvider;
import com.Food.entity.User;
import com.Food.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtProvider jwtProvider;

    @Override
    public User findUserByJwtToken(String jwt) throws Exception {
        String email= jwtProvider.getEmailFromJwtToken(jwt);

        User user=userRepository.findByEmail(email);

        //additional if token is wrong
         if(user==null)
             throw new Exception("token is not valid");

        return user;
    }

    @Override
    public User findUserByEmail(String email) throws Exception {
        User user=userRepository.findByEmail(email);

        if(user==null){
            throw new Exception("User not Found");
        }

        return user;
    }
}
