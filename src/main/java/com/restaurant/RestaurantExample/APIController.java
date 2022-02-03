package com.restaurant.RestaurantExample;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class APIController {

    @Autowired
    private ProductServiceImpl productServiceImpl;

    @PatchMapping("/products/{id}/count/{count}")
    public void updateCount(@PathVariable int id, @PathVariable int count) {
        productServiceImpl.updateCount(id, count);
    }

}
