package com.example.user.dto;

import jakarta.validation.constraints.NotBlank;

public record UserRequestDTO(

        @NotBlank String name,
        @NotBlank String document,
        @NotBlank String phone,
        @NotBlank String email,
        @NotBlank String password) {
}
