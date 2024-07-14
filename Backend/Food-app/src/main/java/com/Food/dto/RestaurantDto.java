package com.Food.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Embeddable
public class RestaurantDto {

    private String title;

    @Column(length = 1000)
    private List<String> images=new ArrayList<>();

    private String description;

    private Long id;

}
