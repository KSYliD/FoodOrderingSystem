package com.example.foodorderingsystem.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private double price;
    private String details;
    @ManyToOne
    @JoinColumn(name = "cuisine_id")
    private Cuisine cuisine;

    public Dish(String name, double price, String details, Cuisine cuisine) {
        this.name = name;
        this.price = price;
        this.details = details;
        this.cuisine = cuisine;
    }

    public Dish( String name, double price, String details) {
        this.name = name;
        this.price = price;
        this.details = details;
    }
}
