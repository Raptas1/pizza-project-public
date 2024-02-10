package com.gudino.pizzaproject.Data;

import java.util.List;

public interface ToppingsDAI<T> {
    public List<T> findAll();
    public T findByName(String name);
    public T findById(int id);
    public boolean create(T t);
    public boolean update(T t);
    public boolean delete(T t);
    
} 
