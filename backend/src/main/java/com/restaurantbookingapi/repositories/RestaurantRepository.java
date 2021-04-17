package com.restaurantbookingapi.repositories;

import com.restaurantbookingapi.entities.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

// (Entidad, tipo de dato de primary key)
// * Solo se define las consultas contra la entidad
// * No entra la lògica de negocio
// @Repository
// @Entities
// Principios SOLID

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

    //@Query("SELECT rest FROM Restaurant rest WHERE rest.id=?1")

    //Optional<Restaurant> findById(Long id);

    //Optional<Restaurant> findByName(String name);

    @Query("SELECT Rest FROM Restaurant  Rest")
    List<Restaurant> findByRestaurants();
}
