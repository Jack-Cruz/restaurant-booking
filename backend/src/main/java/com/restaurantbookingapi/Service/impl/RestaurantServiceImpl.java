package com.restaurantbookingapi.Service.impl;

import com.restaurantbookingapi.Service.RestaurantService;
import com.restaurantbookingapi.dtos.CreateRestaurantDto;
import com.restaurantbookingapi.dtos.RestaurantDto;
import com.restaurantbookingapi.entities.Restaurant;
import com.restaurantbookingapi.exceptions.BookingException;
import com.restaurantbookingapi.exceptions.InternalServerErrorException;
import com.restaurantbookingapi.exceptions.NotFoundException;
import com.restaurantbookingapi.repositories.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    private static final ModelMapper modelMapper = new ModelMapper();

    @Override
    public RestaurantDto getRestaurantById(Long restaurantId) throws BookingException {
        return modelMapper.map(getRestaurantEntity(restaurantId), RestaurantDto.class);
    }

    @Override
    public List<RestaurantDto> getRestaurants() throws BookingException {
        List<Restaurant> restaurantsEntity = restaurantRepository.findAll();
        return restaurantsEntity.stream().map(restaurant -> modelMapper.map(restaurant, RestaurantDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public RestaurantDto createRestaurant(CreateRestaurantDto createRestaurantDto) throws BookingException {
        Restaurant restaurant = new Restaurant();
        restaurant.setName(createRestaurantDto.getName());
        restaurant.setAddress(createRestaurantDto.getAddress());
        restaurant.setDescription(createRestaurantDto.getDescription());
        restaurant.setImage(createRestaurantDto.getImage());

        try{
            restaurant = restaurantRepository.save(restaurant);
        }catch (Exception ex){
            throw new InternalServerErrorException("INTERNAL_SERVER_ERROR", "INTERNAL_SERVER_ERROR");
        }
        return modelMapper.map(getRestaurantEntity((restaurant.getId())), RestaurantDto.class);
    }

    private Restaurant getRestaurantEntity(Long restaurantIg) throws BookingException{
        return restaurantRepository.findById(restaurantIg)
                .orElseThrow(()-> new NotFoundException("NOTFOUND-404", "RESTAURANT-NOT FOUND-404"));
    }
}
