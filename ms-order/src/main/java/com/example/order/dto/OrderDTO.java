package com.example.order.dto;

import com.example.order.feign.UserDTO;
import com.example.order.model.Order;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.Instant;
import java.util.UUID;

public record OrderDTO(
        UUID id,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "UTC") Instant moment,
        UserDTO client) {

}
