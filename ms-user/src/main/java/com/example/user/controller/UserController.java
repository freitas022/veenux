package com.example.user.controller;

import com.example.user.dto.PageResponseDTO;
import com.example.user.dto.UserRequestDTO;
import com.example.user.model.User;
import com.example.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequiredArgsConstructor
@RestController()
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User save(@RequestBody @Valid UserRequestDTO userDTO) {
        return userService.save(userDTO);
    }

    @GetMapping(path = "/all")
    @ResponseStatus(HttpStatus.OK)
    public PageResponseDTO findAll(@PageableDefault(page = 0,
                                                    size = 20,
                                                    sort = "name",
                                                    direction = Sort.Direction.ASC) Pageable pageable) {
        return userService.findAll(pageable);
    }

    @GetMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User findById(@PathVariable UUID id) {
        return userService.findById(id);
    }
}
