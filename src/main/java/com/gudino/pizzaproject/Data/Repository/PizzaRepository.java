package com.gudino.pizzaproject.Data.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gudino.pizzaproject.Entity.PizzaEntity;

@Repository
public interface PizzaRepository extends CrudRepository<PizzaEntity, Integer>{
    PizzaEntity findByName(String name);
}
