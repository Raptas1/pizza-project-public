package com.gudino.pizzaproject.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gudino.pizzaproject.Data.PizzaToppingsDataService;
import com.gudino.pizzaproject.Data.ToppingsDataService;
import com.gudino.pizzaproject.Models.Toppings;

@Service
public class ToppingsService implements ToppingsServiceInterface {

    @Autowired
    private ToppingsDataService service;

    @Autowired
    private PizzaToppingsDataService pizzaToppingsDataService;

    @Override
    public List<Toppings> getAll() {
        return service.findAll();
    }

    @Override
    public Toppings getToppingByName(String name) {
        Toppings topping = service.findByName(name);
        if(topping != null) {
            return topping;
        }
        return null;
    }

    @Override
    public boolean createTopping(Toppings topping) {
        Toppings doesToppingExist = getToppingByName(topping.getName());
        if(doesToppingExist == null) {
            service.create(topping);
            return true;
        }
       return false;
    }

    @Override
    public boolean updateTopping(Toppings topping) {
        try {
            service.update(topping);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteTopping(Toppings topping) {
        try {
            service.delete(topping);
            pizzaToppingsDataService.deleteByToppingId(topping.getId());
            return true;
        } catch (Exception e) {
           e.printStackTrace();
           return false;
        }
    }

    @Override
    public Toppings getToppingById(int id) {
        try {
            return service.findById(id);
        } catch (Exception e ) {
            e.printStackTrace();
            return null;
        }
    }

    
}
