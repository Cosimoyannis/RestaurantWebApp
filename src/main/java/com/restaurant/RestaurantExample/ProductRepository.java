package com.restaurant.RestaurantExample;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepository extends JpaRepository<com.restaurant.RestaurantExample.Product, Integer> {



}
