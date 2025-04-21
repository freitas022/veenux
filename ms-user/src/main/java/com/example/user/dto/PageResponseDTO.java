package com.example.user.dto;

import com.example.user.model.User;

import java.util.List;

public record PageResponseDTO(List<User> content, PaginationDTO pagination) {
}
