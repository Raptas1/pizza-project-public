package com.gudino.pizzaproject.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gudino.pizzaproject.Data.PizzaDataService;
import com.gudino.pizzaproject.Data.PizzaToppingsDataService;
import com.gudino.pizzaproject.Entity.PizzaEntity;
import com.gudino.pizzaproject.Models.Pizza;
import com.gudino.pizzaproject.Models.PizzaToppings;
import com.gudino.pizzaproject.Models.Toppings;

@Service
public class PizzaService implements PizzaServiceInterface<Pizza> {

    @Autowired
    private PizzaDataService pizzaDataService;

    @Autowired
    private PizzaToppingsDataService pizzaToppingsDataService;

    @Autowired
    private ToppingsService toppingsService;

    @Override
    public boolean createPizza(Pizza pizza) {
        PizzaEntity DoesPizzaExist = pizzaDataService.findByName(pizza.getName());
        if(DoesPizzaExist != null) {
            return false;
        }
        PizzaEntity pizzaEntity = new PizzaEntity(pizza.getName());
        PizzaEntity savePizza = pizzaDataService.create(pizzaEntity);
        if(pizza.getToppings() != null) {
            for(Toppings toppings : pizza.getToppings()) {
                PizzaToppings pizzaToppings = new PizzaToppings(savePizza.getId(), toppings.getId());
                pizzaToppingsDataService.create(pizzaToppings);
            }
        }
        return true;
    }

    @Override
    public boolean updatePizza(Pizza pizza) {
        try {
            PizzaEntity pizzaEntity = new PizzaEntity(pizza.getId(), pizza.getName());
            pizzaDataService.update(pizzaEntity);
            pizzaToppingsDataService.deleteByPizzaId(pizza.getId());
            for(Toppings topping : pizza.getToppings()) {
                PizzaToppings pizzaToppings = new PizzaToppings(pizza.getId(), topping.getId());
                pizzaToppingsDataService.update(pizzaToppings);
            }
            return true;
        } catch (Exception e) {
           e.printStackTrace();
           return false;
        }
    }

    @Override
    public boolean deletePizza(Pizza pizza) {
        try {
            PizzaEntity pizzaEntity = new PizzaEntity(pizza.getId(), pizza.getName());
            pizzaDataService.delete(pizzaEntity);
            pizzaToppingsDataService.deleteByPizzaId(pizza.getId());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Pizza> getAllPizzas() {
        try {
            List<Pizza> pizzas = new ArrayList<Pizza>();
            List<PizzaEntity> pizzaEntity = pizzaDataService.findAll();
    
            for(PizzaEntity pizza : pizzaEntity) {
                List<PizzaToppings> pizzaToppings = pizzaToppingsDataService.findAllByPizzaId(pizza.getId());
                List<Toppings> toppings = new ArrayList<Toppings>();
                for(PizzaToppings pizzaTopping : pizzaToppings) {
                    Toppings topping = toppingsService.getToppingById(pizzaTopping.getToppingId());
                    toppings.add(topping);
                }
                Pizza pizzaModel = new Pizza(pizza.getId(), pizza.getName(), toppings);
                pizzas.add(pizzaModel);
            }
            return pizzas;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Pizza getPizzaById(int id) {
        try {
            PizzaEntity pizzaEntity = pizzaDataService.findById(id);
            List<PizzaToppings> pizzaToppings = pizzaToppingsDataService.findAllByPizzaId(id);
            List<Toppings> toppings = new ArrayList<Toppings>();
            for(PizzaToppings pizzaTopping : pizzaToppings) {
                Toppings topping = toppingsService.getToppingById(pizzaTopping.getToppingId());
                toppings.add(topping);
            }
            Pizza pizzaModel = new Pizza(pizzaEntity.getId(), pizzaEntity.getName(), toppings);
            return pizzaModel;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Toppings> getToppingsByPizzaId(int id) {
        try {
            List<PizzaToppings> pizzaToppings = pizzaToppingsDataService.findAllByPizzaId(id);
            List<Toppings> toppings = new ArrayList<Toppings>();
            for(PizzaToppings pizzaTopping : pizzaToppings) {
                Toppings topping = toppingsService.getToppingById(pizzaTopping.getToppingId());
                toppings.add(topping);
            }
            return toppings;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
}
