package com.example.foodorderingsystem.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "orders")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Integer tableNum;
    @ManyToOne
    @JoinColumn(name = "mainCourse_id")
    private Dish mainCourse;
    @ManyToOne
    @JoinColumn(name = "dessert_id")
    private Dessert dessert;
    @ManyToOne
    @JoinColumn(name = "drink_id")
    private Drink drink;
    private String details;

    public Order(Integer tableNum, Dish mainCourse, Dessert dessert, Drink drink, String details) {
        this.tableNum = tableNum;
        this.mainCourse = mainCourse;
        this.dessert = dessert;
        this.drink = drink;
        this.details = details;
    }
}
