package com.gudino.pizzaproject.Models;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("PizzaToppings")
public class PizzaToppings {
    @Id
    private int id;

    @Column("pizzaId")
    private int pizzaId;

    @Column("toppingId")
    private int toppingId;

    public PizzaToppings() {
    }

    public PizzaToppings(int pizzaId, int toppingId) {
        this.pizzaId = pizzaId;
        this.toppingId = toppingId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPizzaId() {
        return pizzaId;
    }

    public void setPizzaId(int pizzaId) {
        this.pizzaId = pizzaId;
    }

    public int getToppingId() {
        return toppingId;
    }

    public void setToppingId(int toppingId) {
        this.toppingId = toppingId;
    }

    
}
