package com.example.transfer_of_fruit_api_to_my_own_api.dto;

import com.example.transfer_of_fruit_api_to_my_own_api.model.Fruit;
import java.time.LocalDateTime;

public record FruitResponse(Fruit fruit, LocalDateTime requestedAt) {
}
