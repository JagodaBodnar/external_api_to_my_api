package com.example.transfer_of_fruit_api_to_my_own_api.controller;

import com.example.transfer_of_fruit_api_to_my_own_api.dto.FruitResponse;
import com.example.transfer_of_fruit_api_to_my_own_api.dto.FruityviceListResponseDto;
import com.example.transfer_of_fruit_api_to_my_own_api.model.Fruit;
import com.example.transfer_of_fruit_api_to_my_own_api.service.FruitClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import java.util.List;

@RestController
@RequestMapping("/api/fruit")
public class FruitsController {
    private final FruitClient service;

    @Autowired
    public FruitsController(FruitClient service) {
        this.service = service;
    }

    @GetMapping("/all")
    public Flux<FruityviceListResponseDto> getFruits(){
        return service.getFruits();
    }

    @GetMapping(value = "/{id}")
    public FruitResponse getFruit(@PathVariable int id){
        return service.getFruit(id);
    }

   @GetMapping
   //localhost:8080/api/fruit/ -->
    public FruitResponse getFruit(@RequestParam(value = "name") String name){
        return service.getFruitByName(name);
    }
}
