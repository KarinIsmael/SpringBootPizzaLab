package com.example.springbootpizzademo.controllers;

import com.example.springbootpizzademo.entities.Pizza;
import com.example.springbootpizzademo.repositories.PizzaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = {PizzaController.class})
class PizzaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PizzaRepository pizzaRepository;

    @Test
    void getPizzaWithID4ReturnsCalzone() throws Exception {
        when(pizzaRepository.findById(any()))
                .thenReturn(java.util.Optional.of(new Pizza(4L, "test", 120, "test")));


        var result =
                mockMvc.perform(MockMvcRequestBuilders.get("/pizzas/4"))
                        .andExpect(status().isOk())
                        .andReturn().getResponse().getContentAsString();
        assertThat(result)
                .isEqualTo("{\"id\":4,\"name\":\"test\",\"price\":120,\"ingredients\":\"test\"}");
    }


        @Test
        void getAllPizzaReturnOnePizza() throws Exception{
            when(pizzaRepository.findAll()).thenReturn(List.of(new Pizza(1L,"Test",100,"Test")));
            var result = mockMvc.perform(MockMvcRequestBuilders.get("/pizzas"))
                    .andExpect(status().is(200))
                    .andReturn().getResponse().getContentAsString();
            assertThat(result).isEqualTo("[{\"id\":1,\"name\":\"Test\",\"price\":100,\"ingredients\":\"Test\"}]");

        }


}