package com.example.springbootpizzademo.repositories;

import com.example.springbootpizzademo.entities.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PizzaRepository extends JpaRepository<Pizza, Long> {

    List<Pizza> findAllByNameAndPrice(String name, int price);

}
