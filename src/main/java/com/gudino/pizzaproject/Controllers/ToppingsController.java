package com.gudino.pizzaproject.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gudino.pizzaproject.Models.Toppings;
import com.gudino.pizzaproject.Services.ToppingsService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
@RequestMapping("/Toppings")
public class ToppingsController {

    @Autowired
    private ToppingsService toppingsService;

    @GetMapping("")
    public String displayToppings(Model model) {
        model.addAttribute("ToppingsModel", new Toppings());
        model.addAttribute("Toppings", toppingsService.getAll());
        return "Toppings";
    }

    @PostMapping("/create")
    public String createTopping(@Valid @ModelAttribute("ToppingsModel") Toppings toppings, BindingResult bindingResult, Model model) {
        model.addAttribute("Toppings", toppingsService.getAll());

        if(bindingResult.hasErrors()) {
            return "/Toppings";
        }

        boolean response = toppingsService.createTopping(toppings);
        if(response == false) {
            bindingResult.rejectValue("name", "error.name", "Topping already exists!");
            return "/Toppings";
        }

        return "redirect:/Toppings";
    }

    @PostMapping("/edit")
    public String editTopping(@ModelAttribute("ToppingsModel") Toppings toppings, Model model) {
        model.addAttribute("ToppingsModel", toppings);
        return "/editToppings";
    }

    @PostMapping("/editSuccess")
    public String successEdit(Toppings topping) {
        toppingsService.updateTopping(topping);
        return "redirect:/Toppings";
    }

    @PostMapping("/delete")
    public String deleteTopping(@ModelAttribute("ToppingsModel") Toppings toppings, Model model) {
        model.addAttribute("ToppingsModel", toppings);
        return "/deleteToppings";
    }
    
    @PostMapping("/deleteSuccess")
    public String successDelete(Toppings topping) {
        toppingsService.deleteTopping(topping);
        return "redirect:/Toppings";
    }
    
    
}
