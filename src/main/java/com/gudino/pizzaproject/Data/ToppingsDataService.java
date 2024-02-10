package com.gudino.pizzaproject.Data;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gudino.pizzaproject.Data.Repository.ToppingsRepository;
import com.gudino.pizzaproject.Models.Toppings;

@Service
public class ToppingsDataService implements ToppingsDAI<Toppings> {

    @Autowired
    private ToppingsRepository toppingsRepository;

    public ToppingsDataService(ToppingsRepository toppingsRepository) {
        this.toppingsRepository = toppingsRepository;
    }

    @Override
    public Toppings findByName(String name) {
        try {
            return toppingsRepository.findByName(name);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean create(Toppings t) {
        try {
            toppingsRepository.save(t);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Toppings t) {
        try {
            toppingsRepository.save(t);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(Toppings t) {
        try {
            toppingsRepository.delete(t);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Toppings> findAll() {
        try {
            return (List<Toppings>) toppingsRepository.findAll();
        } catch (Exception e) {
           e.printStackTrace();
           return null;
        }
    }

    @Override
    public Toppings findById(int id) {
        try {
            Optional<Toppings> topping = toppingsRepository.findById(id);
            if(topping.isPresent()) {
                return topping.get();
            }
            return null;
        } catch (Exception e) {
           e.printStackTrace();
           return null;
        }
    }

    
    
}
