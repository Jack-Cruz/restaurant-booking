package com.restaurantbookingapi.Service;

import com.restaurantbookingapi.dtos.CreateRestaurantDto;
import com.restaurantbookingapi.dtos.RestaurantDto;
import com.restaurantbookingapi.exceptions.BookingException;

import java.util.List;

public interface RestaurantService {
    RestaurantDto getRestaurantById(Long restaurant) throws BookingException;
    List<RestaurantDto> getRestaurants() throws BookingException;
    RestaurantDto createRestaurant(CreateRestaurantDto createRestaurantDto) throws BookingException;
}
