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

    /*@GetMapping("/pizzas")
    public List<Pizza>pizzas(){
        return List.of(new Pizza(1L,"Calzone", 100,"Ost, tomatsås, skinka"));
    } *///ovan vill vi göra med att använda vårt repository. Då skapar vi en instans och konstruktor som ovan.
    //då skapar vi en implementation som i nedan metod av vårt repository.

    @GetMapping("/pizzas")
    public List<Pizza> pizzas(){
        return pizzaRepository.findAll();
    } //nu hämtar vi pizzor från databasen med hjälp av vårt repository


   /* @GetMapping("/pizzas/{id}")
    public Pizza kebab(@PathVariable Long id){
        return pizzaRepository.getById(id);
    }*/ //funkar ej ("internal server error")

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

    /*@PatchMapping("/pizzas/{id}")
    public Pizza alterPizza(@PathVariable Long id){
        Optional<Pizza> pizza = pizzaRepository.findById(id);
        if(pizza.isPresent()) {

        }else {
            throw new RuntimeException("Pizza not found for the id "+id);
        }
    }*/

   /* @PatchMapping("/pizzas/{id}/{name}")
    public ResponseEntity<Pizza> alterPizza(@PathVariable Long id, @PathVariable String name) {
        try {
            Pizza pizza = pizzaRepository.findById(id).get();
            pizza.setName(name);
            return new ResponseEntity<Pizza>(pizzaRepository.save(pizza), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping("/customer")
    public ResponseEntity patchSalaryUpdate(@RequestBody Customer customer){

        if(customers.exists(customer.getId())) {
            // get customer from storage
            Customer _customer = customers.get(customer.getId());

            // update new values
            _customer.setSalary(customer.getSalary());

            // save again to customer storage
            customers.add(_customer);

            return new ResponseEntity("Update Successfully!", HttpStatus.OK);
        } else {
            return new ResponseEntity("Not found customer with id = " + customer.getId()
                    , HttpStatus.NOT_FOUND);
        }
    }


    @PatchMapping("/pizzas/{id}")
    public ResponseEntity pizzaUpdate(@PathVariable Long id, @PathVariable String name){
        Optional<Pizza> pizza = pizzaRepository.findById(id);
        if(pizza.isPresent()){

            pizza.get().setName(pizzaUpdate(name));
        }
        return null;
    }


}
}*/



   /* @PatchMapping("/pizzas/{id}")
    public ResponseEntity<Pizza> updatePizza (@PathVariable Long id, @RequestBody Pizza pizza) {
        return ResponseEntity.ok(updatePizza(id,pizza));
    }*/

}
