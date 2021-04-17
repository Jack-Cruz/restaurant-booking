package com.restaurantbookingapi.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RestaurantDto {
    private Long id;
    private String name;
    private String address;
    private String description;
    private String image;
    // Turns
}
