package com.example.transfer_of_fruit_api_to_my_own_api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public record FruityviceResponseDto(
        String name,
        int id,
        String family,
        String order,
        String genus,
        Map<String,Integer> nutritions
) {
}
