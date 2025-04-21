package com.example.user.service;

import java.util.UUID;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.common.exception.exceptions.ResourceNotFoundException;
import com.example.user.dto.PageResponseDTO;
import com.example.user.dto.PaginationDTO;
import com.example.user.dto.UserRequestDTO;
import com.example.user.model.User;
import com.example.user.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User save(UserRequestDTO userDTO) {
        var user = buildUser(userDTO);
        log.info("Registering new user: {}", user);
        return userRepository.save(user);
    }

    public PageResponseDTO findAll(Pageable pageable) {
        log.info("Fetching all registered users, ordered by name");
        var page = userRepository.findAll(pageable);
        PaginationDTO pagination = new PaginationDTO(page);
        return new PageResponseDTO(page.getContent(), pagination);
    }

    public User findById(UUID id) {
        log.info("Fetching user by id: {}", id);
        return userRepository.findById(id)
               .orElseThrow(() -> new ResourceNotFoundException("Resource not found!"));
    }

    private static User buildUser(UserRequestDTO userDTO) {
        return User.builder()
                .name(userDTO.name())
                .document(userDTO.document())
                .phone(userDTO.phone())
                .email(userDTO.email())
                .password(userDTO.password())
                .build();
    }
}
