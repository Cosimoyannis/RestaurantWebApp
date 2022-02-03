package com.restaurant.RestaurantExample;


import com.sun.istack.Nullable;

import javax.persistence.*;


@Entity
@Table (name = "product")
public class Product {

    @Nullable
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Nullable
    private String name;

    @Nullable
    private double price;

    @Nullable
    private String owner;

    @Nullable
    private int count;








    public Product(int id, String name, double price, String owner, int count) {
        this.name = name;
        this.price = price;
        this.id = id;
        this.owner = owner;
        this.count = 1;
    }

    public Product() {

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getCount() {return this.count;}

    public void setCount(int count) {
        this.count = count;
    }


}
