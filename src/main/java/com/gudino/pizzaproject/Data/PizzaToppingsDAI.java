package com.gudino.pizzaproject.Data;

import java.util.List;

public interface PizzaToppingsDAI<T> {
    public List<T> findAllByPizzaId(int id);
    public void deleteByToppingId(int id);
    public void deleteByPizzaId(int id);
    public boolean create(T t);
    public boolean update(T t);
    public boolean delete(T t);
}
