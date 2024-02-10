package com.gudino.pizzaproject.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gudino.pizzaproject.Models.Pizza;
import com.gudino.pizzaproject.Models.Toppings;
import com.gudino.pizzaproject.Services.PizzaService;
import com.gudino.pizzaproject.Services.ToppingsService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;



@Controller
@RequestMapping("/Pizza")
public class PizzaController {

    @Autowired
    private ToppingsService toppingsService;

    @Autowired
    private PizzaService pizzaService;

    @GetMapping("")
    public String displayPizza(Pizza pizza, Model model) {
        model.addAttribute("PizzaModel", new Pizza());
        model.addAttribute("Toppings", toppingsService.getAll());
        model.addAttribute("Pizzas", pizzaService.getAllPizzas());
        return "Pizza";
    }

    @PostMapping("/create")
    public String createPizza(@Valid @ModelAttribute("PizzaModel") Pizza pizza, BindingResult bindingResult, Model model) {
        model.addAttribute("Toppings", toppingsService.getAll());
        model.addAttribute("Pizzas", pizzaService.getAllPizzas());

        if(bindingResult.hasErrors()) {
            return "/Pizza";
        }
        boolean response = pizzaService.createPizza(pizza);
        if(response == false) {
            bindingResult.rejectValue("name", "error.name", "Pizza already exists.");
            return "/Pizza";
        }
        return "redirect:/Pizza";
    }

    @PostMapping("/edit")
    public String editPizza(@ModelAttribute("PizzaModel") Pizza pizza, Model model) {
        model.addAttribute("PizzaModel", pizza);
        model.addAttribute("Toppings", toppingsService.getAll());
        model.addAttribute("currentToppings", pizzaService.getToppingsByPizzaId(pizza.getId()));
        return "/editPizza";
    }

    @PostMapping("/editSuccess")
    public String successEdit(@RequestParam(name="topping") List<Toppings> selectedToppings, Pizza pizza, Model model) {
        pizza.setToppings(selectedToppings);
        pizzaService.updatePizza(pizza);
        return "redirect:/Pizza";
    }

    @PostMapping("/delete")
    public String deletePizza(@ModelAttribute("PizzaModel") Pizza pizza, Model model) {
        model.addAttribute("PizzaModel", pizza);
        return "/deletePizza";
    }

    @PostMapping("/deleteSuccess")
    public String successDelete(Pizza pizza) {
        pizzaService.deletePizza(pizza);
        return "redirect:/Pizza";
    }
    
    
}
