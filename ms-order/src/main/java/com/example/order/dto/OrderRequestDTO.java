package com.example.order.dto;

import java.util.UUID;

public record OrderRequestDTO(UUID id, UUID clientId) {
}
