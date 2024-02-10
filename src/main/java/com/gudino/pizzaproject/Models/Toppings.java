package com.gudino.pizzaproject.Models;

import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import jakarta.validation.constraints.NotEmpty;

@Table("Toppings")
public class Toppings {
    @Id
    private int id;

    @Column("name")
    @NotEmpty(message="Topping name is required!")
    private String name;


    public Toppings() {

    }

    public Toppings(String name) {
        this.name = name;
    }

    public Toppings(int id, String name) {
        this.id = id;
        this.name = name;
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

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null) return false;
        Toppings topping = (Toppings) o;
        return this.id == topping.id && Objects.equals(this.name, topping.name);
    }



}
