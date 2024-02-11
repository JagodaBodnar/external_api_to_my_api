package com.example.transfer_of_fruit_api_to_my_own_api.controller;

import com.example.transfer_of_fruit_api_to_my_own_api.dto.FruitResponse;
import com.example.transfer_of_fruit_api_to_my_own_api.dto.FruityviceListResponseDto;
import com.example.transfer_of_fruit_api_to_my_own_api.model.Fruit;
import com.example.transfer_of_fruit_api_to_my_own_api.service.FruitClient;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    @Operation(description = "List of fruits", summary = "Returns list of fruits")
    @ApiResponse(responseCode = "200", description = "Successful fetch of fruits")
    public Flux<FruityviceListResponseDto> getFruits(){
        return service.getFruits();
    }

    @GetMapping(value = "/{id}")
    @Operation(description = "Single fruit", summary = "Returns fruit by provided id")
    @ApiResponse(responseCode = "200", description = "Successful fetch of fruits")
    @ApiResponse(responseCode = "404", description = "Successful fetch of fruits")
    @Parameter(name="id", description = "Id of the fruit", required = true, allowEmptyValue = false)
    public ResponseEntity<FruitResponse> getFruit(@PathVariable int id){
        try{
            return ResponseEntity.ok(service.getFruit(id));
        }catch(Exception e){
            return ResponseEntity.badRequest().build();
        }

    }

   @GetMapping
   @Operation(description = "Single fruit", summary = "Returns fruit by name")
   @Parameter(name="name", description = "Name of the fruit", required = true, allowEmptyValue = false)
   //localhost:8080/api/fruit/ -->
    public FruitResponse getFruit(@RequestParam(value = "name") String name){
        return service.getFruitByName(name);
    }
}
