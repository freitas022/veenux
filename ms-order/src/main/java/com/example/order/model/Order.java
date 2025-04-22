package com.example.order.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.util.UUID;

@Builder
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "TB_ORDER")
public class Order {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @CreationTimestamp
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "UTC")
    private Instant moment;

    private UUID clientId;

}
