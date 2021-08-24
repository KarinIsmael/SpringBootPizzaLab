package com.example.springbootpizzademo.controllers;

import com.example.springbootpizzademo.entities.Pizza;
import com.example.springbootpizzademo.repositories.PizzaRepository;
import org.assertj.core.api.AbstractBooleanAssert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

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