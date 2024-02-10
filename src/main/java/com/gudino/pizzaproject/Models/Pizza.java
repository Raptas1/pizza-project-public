package com.gudino.pizzaproject.Models;

import java.util.List;

import jakarta.validation.constraints.NotEmpty;

public class Pizza {

    private int id;
    @NotEmpty(message = "Pizza name cannot be empty!")
    private String name;

    private List<Toppings> toppings;

    public Pizza() {

    }

    public Pizza(String name, List<Toppings> toppings) {
        this.name = name;
        this.toppings = toppings;
    }

    public Pizza(int id, String name, List<Toppings> toppings) {
        this.id = id;
        this.name = name;
        this.toppings = toppings;
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

    public List<Toppings> getToppings() {
        return toppings;
    }

    public void setToppings(List<Toppings> toppings) {
        this.toppings = toppings;
    }

    
}
