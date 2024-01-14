package com.example.transfer_of_fruit_api_to_my_own_api.service;

import com.example.transfer_of_fruit_api_to_my_own_api.dto.FruitResponse;
import com.example.transfer_of_fruit_api_to_my_own_api.dto.FruityviceListResponseDto;
import com.example.transfer_of_fruit_api_to_my_own_api.dto.FruityviceResponseDto;
import com.example.transfer_of_fruit_api_to_my_own_api.model.Fruit;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.time.LocalDateTime;

@Service
public class FruitClient {
    private final WebClient client;

    public FruitClient(@Value("${fruit-url}") String baseUrl){
        client = WebClient.create(baseUrl);
    }
//    https://www.fruityvice.com/
    public FruitResponse getFruit(int id){
        var dto = client.get()
                .uri("fruit/{id}", id)
                .retrieve()
                .bodyToMono(FruityviceResponseDto.class)
                .block();
                var fruit = new Fruit(dto.name(), dto.nutritions());
                return new FruitResponse(
                        fruit, LocalDateTime.now()
                );
    }
    public Flux<FruityviceListResponseDto> getFruits(){
        var dto = client.get()
                .uri("fruit/all")
                .retrieve()
//                .bodyToMono(new ParameterizedTypeReference<List<FruityviceListResponseDto>>() {})
                .bodyToFlux(FruityviceListResponseDto.class);
        return dto;
    }

    public FruitResponse getFruitByName(String name) {
        var dto = client.get()
                .uri("fruit/{name}", name)
                .retrieve()
                .bodyToMono(FruityviceResponseDto.class)
                .block();
        var fruit = new Fruit(dto.name(), dto.nutritions());
        return new FruitResponse(
                fruit, LocalDateTime.now()
        );
    }
}
