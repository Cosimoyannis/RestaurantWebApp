package com.restaurant.RestaurantExample;


import com.sun.istack.Nullable;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;


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

    @Nullable
    private Date date;

    @Nullable
    private Time time;

    @Nullable
    private int personCount;

    @Nullable
    private int tableId;






    public Product(int id, String name, double price, String owner, int count, Date date, Time time, int personCount, int tableId) {
        this.name = name;
        this.price = price;
        this.id = id;
        this.owner = owner;
        this.count = 1;
        this.date = date;
        this.time = time;
        this.personCount = personCount;
        this.tableId = tableId;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public int getPersonCount() {
        return personCount;
    }

    public void setPersonCount(int personCount) {
        this.personCount = personCount;
    }

    public int getTableId() {
        return tableId;
    }

    public void setTableId(int tableId) {
        this.tableId = tableId;
    }
}
