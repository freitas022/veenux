package com.example.user.dto;

import org.springframework.data.domain.Page;

public record PaginationDTO(int page, int size, long totalElements, int totalPages) {

    public PaginationDTO(Page<?> page) {
        this(page.getNumber(), page.getSize(), page.getTotalElements(), page.getTotalPages());
    }
}
