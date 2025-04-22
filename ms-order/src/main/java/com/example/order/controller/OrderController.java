package com.example.order.controller;

import com.example.common.exception.exceptions.ResourceNotFoundException;
import com.example.order.dto.OrderDTO;
import com.example.order.dto.OrderRequestDTO;
import com.example.order.feign.UserFeignClient;
import com.example.order.service.OrderService;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/order")
public class OrderController {

    private final OrderService orderService;
    private final UserFeignClient userFeignClient;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrderDTO save(@RequestBody OrderRequestDTO orderDTO) {
        try {
            var user = userFeignClient.findById(orderDTO.clientId());
            var order = orderService.save(orderDTO);
            return new OrderDTO(order.getId(), order.getMoment(), user);
        } catch (FeignException.NotFound ex) {
            throw new ResourceNotFoundException("Client not found");
        }
    }

    @GetMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public OrderDTO findById(@PathVariable UUID id) {
        try {
            var order = orderService.findById(id);
            var user = userFeignClient.findById(order.getClientId());
            return new OrderDTO(order.getId(), order.getMoment(), user);
        } catch (FeignException.NotFound ex) {
            throw new ResourceNotFoundException("Client not found");
        }
    }
}
