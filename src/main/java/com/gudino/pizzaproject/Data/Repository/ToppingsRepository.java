package com.gudino.pizzaproject.Data.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gudino.pizzaproject.Models.Toppings;


@Repository
public interface ToppingsRepository extends CrudRepository<Toppings, Integer> {
    Toppings findByName(String name);
}