package com.example.user.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

@Builder
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "TB_USER")
public class User implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Length(min = 3, message = "Name should be at least 3 characters.")
    private String name;

    @Column(unique = true, nullable = false)
    private String document;

    @Column(unique = true, nullable = false)
    private String phone;

    @Email(message = "Email should be valid.")
    private String email;

    @Length(min = 8, message = "Password should be at least 8 characters.")
    @JsonIgnore
    private String password;

    @CreationTimestamp
    @JsonFormat(
            shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "UTC")
    private Instant createdAt;
}
