package com.Food.entity;

import com.Food.dto.RestaurantDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String fullName;

    private String email;

    private String password;

    private USER_ROLE role=USER_ROLE.ROLE_CUSTOMER;/////

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL ,mappedBy = "customer")
    private List<Order> orders=new ArrayList<>();

    @ElementCollection
    private List<RestaurantDto>favorites=new ArrayList<>(); ///


    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Address>addresses=new ArrayList<>();



}
//1:43:50