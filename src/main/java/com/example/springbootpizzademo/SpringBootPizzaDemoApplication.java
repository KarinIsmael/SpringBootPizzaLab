package com.example.springbootpizzademo;

import com.example.springbootpizzademo.entities.Pizza;
import com.example.springbootpizzademo.repositories.PizzaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootPizzaDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootPizzaDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner init(PizzaRepository pizzaRepository){

        pizzaRepository.save(new Pizza(1L, "kebab", 120, "ost, tomatsås, kebab, isbergssallad, kebabsås"));
        pizzaRepository.save(new Pizza(2L, "kebab", 150, "ost, tomatsås, kebab, isbergssallad, kebabsås"));


        return (args) ->{

            if(pizzaRepository.count()==0){
                pizzaRepository.save(new Pizza(0L,"Calzone",140,"ost,tomatsås,skinka"));
            }
        };

    }
}
