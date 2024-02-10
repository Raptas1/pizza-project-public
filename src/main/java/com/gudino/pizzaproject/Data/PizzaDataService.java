package com.gudino.pizzaproject.Data;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gudino.pizzaproject.Data.Repository.PizzaRepository;
import com.gudino.pizzaproject.Entity.PizzaEntity;

@Service
public class PizzaDataService implements PizzaDAI<PizzaEntity> {

    @Autowired
    private PizzaRepository pizzaRepository;

    public PizzaDataService(PizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }

    @Override
    public List<PizzaEntity> findAll() {
        try {
            return (List<PizzaEntity>) pizzaRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public PizzaEntity findByName(String name) {
        try {
            return pizzaRepository.findByName(name);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public PizzaEntity create(PizzaEntity pizza) {
        try {
            return pizzaRepository.save(pizza);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean update(PizzaEntity pizza) {
        try {
            pizzaRepository.save(pizza);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(PizzaEntity pizza) {
        try {
           pizzaRepository.delete(pizza);
           return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public PizzaEntity findById(int id) {
        try {
            Optional<PizzaEntity> pizzaEntity = pizzaRepository.findById(id);
            if(pizzaEntity.isPresent()) {
                return pizzaEntity.get();
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
}
