package com.restaurantbookingapi.controllers;


import com.restaurantbookingapi.dtos.CreateRestaurantDto;
import com.restaurantbookingapi.dtos.RestaurantDto;
import com.restaurantbookingapi.exceptions.BookingException;
import com.restaurantbookingapi.responses.BookingResponse;
import com.restaurantbookingapi.Service.RestaurantService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/restaurant-booking"+"/v1")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path = "/restaurants/{restaurantId}")
    public BookingResponse<RestaurantDto> getRestaurantById(@PathVariable Long restaurantId)
        throws BookingException {
        return new BookingResponse<>("Success", String.valueOf(HttpStatus.OK), "OK",
            restaurantService.getRestaurantById(restaurantId));
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path = "/restaurants")
    public BookingResponse<List<RestaurantDto>> getRestaurants()
            throws BookingException {
        return new BookingResponse<>("Success", String.valueOf(HttpStatus.OK), "OK",
                restaurantService.getRestaurants());
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping(path = "/restaurants")
    public BookingResponse<RestaurantDto> createRestaurant(@RequestBody CreateRestaurantDto createRestaurantDto)
            throws BookingException {
        return new BookingResponse<>("Success", String.valueOf(HttpStatus.OK), "OK",
                restaurantService.createRestaurant(createRestaurantDto));
    }

}
