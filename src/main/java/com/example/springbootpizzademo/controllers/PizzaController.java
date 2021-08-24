package com.example.springbootpizzademo.controllers;

import com.example.springbootpizzademo.entities.Pizza;
import com.example.springbootpizzademo.repositories.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PizzaController {

    @Autowired
    private PizzaRepository pizzaRepository;

    public PizzaController(PizzaRepository pizzaRepository){
        this.pizzaRepository = pizzaRepository;
    }

    @GetMapping("/pizzas")
    public List<Pizza> pizzas(){
        return pizzaRepository.findAll();
    }

    @GetMapping("/pizzas/{id}")
    public Pizza kebab(@PathVariable Long id){
        Optional<Pizza> pizza = pizzaRepository.findById(id);
        if(pizza.isPresent()) {
            return pizza.get();
        }else {
            throw new RuntimeException("Pizza not found for the id "+id);
        }
    }

   @DeleteMapping("/pizzas/{id}")
    public String delete(@PathVariable Long id){
        Optional<Pizza> pizza = pizzaRepository.findById(id);
        if(pizza.isPresent()){
            pizzaRepository.delete(pizza.get());
            return "Pizza with id "+id+" is deleted";
        } else{
            throw new RuntimeException("Pizza not found for the id "+id);
        }
    }

    @PostMapping("/pizzas")
    public Pizza addPizza(@RequestBody Pizza newPizza){
        return pizzaRepository.save(newPizza);
    }

    @PutMapping("/pizzas")
    public Pizza changePizza(@RequestBody Pizza changedPizza){
        return pizzaRepository.save(changedPizza);
    }

    @PatchMapping(("/pizzas/{id}/{name}"))
    public Pizza alterPizza(@PathVariable Long id, @PathVariable String name,@RequestBody Pizza body){
        Optional<Pizza> findPizza = pizzaRepository.findById(id);
        if (findPizza.isPresent()){
            Pizza pizza = findPizza.get();
            pizza.setName(body.getName());
            return pizzaRepository.save(pizza);
        }else {
            throw new RuntimeException("Pizza not found for the id: "+id);
        }
    }

}