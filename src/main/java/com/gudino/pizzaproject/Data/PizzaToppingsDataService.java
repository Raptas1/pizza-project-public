package com.gudino.pizzaproject.Data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gudino.pizzaproject.Data.Repository.PizzaToppingsRepository;
import com.gudino.pizzaproject.Models.PizzaToppings;

@Service
public class PizzaToppingsDataService implements PizzaToppingsDAI<PizzaToppings> {

    @Autowired
    private PizzaToppingsRepository pizzaToppingsRepository;

    public PizzaToppingsDataService(PizzaToppingsRepository pizzaToppingsRepository) {
        this.pizzaToppingsRepository = pizzaToppingsRepository;
    }

    @Override
    public boolean create(PizzaToppings pizzaToppings) {
        try {
            pizzaToppingsRepository.save(pizzaToppings);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(PizzaToppings pizzaToppings) {
        try {
            pizzaToppingsRepository.save(pizzaToppings);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(PizzaToppings pizzaToppings) {
        try {
            pizzaToppingsRepository.delete(pizzaToppings);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<PizzaToppings> findAllByPizzaId(int id) {
       try {
       return pizzaToppingsRepository.findAllByPizzaId(id);
       } catch (Exception e) {
        return null;
       }
    }

    @Override
    public void deleteByToppingId(int id) {
        try {
            pizzaToppingsRepository.deleteByToppingId(id);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteByPizzaId(int id) {
        try {
            pizzaToppingsRepository.deleteByPizzaId(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
