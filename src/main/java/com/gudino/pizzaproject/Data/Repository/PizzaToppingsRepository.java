package com.gudino.pizzaproject.Data.Repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gudino.pizzaproject.Models.PizzaToppings;


@Repository
public interface PizzaToppingsRepository extends CrudRepository<PizzaToppings, Integer> {
    public List<PizzaToppings> findAllByPizzaId(int id);

    @Modifying
    @Query("DELETE FROM PizzaToppings WHERE toppingId = :toppingId")
    public void deleteByToppingId(@Param("toppingId") int toppingId);
    @Modifying
    @Query("DELETE FROM PizzaToppings WHERE pizzaId = :pizzaId")
    public void deleteByPizzaId(@Param("pizzaId") int pizzaId);
}