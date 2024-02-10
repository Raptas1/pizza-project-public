package com.gudino.pizzaproject.Services;

import java.util.List;

import com.gudino.pizzaproject.Models.Toppings;

public interface ToppingsServiceInterface {
    public List<Toppings> getAll();
    public Toppings getToppingByName(String name);
    public Toppings getToppingById (int id);
    public boolean createTopping(Toppings topping);
    public boolean updateTopping(Toppings topping);
    public boolean deleteTopping(Toppings topping);

}
