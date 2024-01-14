package com.example.transfer_of_fruit_api_to_my_own_api.dto;
import java.util.Map;

public record FruityviceListResponseDto(String name, int id, String family, String order, String genus, Map<String,Integer> nutritions) {

}
