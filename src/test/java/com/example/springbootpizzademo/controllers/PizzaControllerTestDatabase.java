package com.example.springbootpizzademo.controllers;

import com.example.springbootpizzademo.repositories.PizzaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class PizzaControllerTestDatabase {

    @Mock
    PizzaRepository pizzaRepository;

    @Test
    void getAllPizzasInDatabase(){
        PizzaController pizzaController = new PizzaController(pizzaRepository);
        assertThat(pizzaController.pizzas()).isEmpty();
    }
}