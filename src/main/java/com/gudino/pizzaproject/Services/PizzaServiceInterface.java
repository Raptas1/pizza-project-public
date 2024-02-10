package com.gudino.pizzaproject.Services;

import java.util.List;

import com.gudino.pizzaproject.Models.Toppings;

public interface PizzaServiceInterface<T> {
    public boolean createPizza(T t);
    public boolean updatePizza(T t);
    public boolean deletePizza(T t);
    public List<T> getAllPizzas();
    public T getPizzaById(int id);
    public List<Toppings> getToppingsByPizzaId(int id);
}
