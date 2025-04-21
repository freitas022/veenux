package com.example.common.exception.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.Instant;

public record ErrorResponseDTO(

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "UTC") Instant timestamp,
        int status,
        String error,
        String path
                            ) {
}
