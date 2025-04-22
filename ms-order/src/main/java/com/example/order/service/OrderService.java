package com.example.order.service;

import com.example.common.exception.exceptions.ResourceNotFoundException;
import com.example.order.dto.OrderRequestDTO;
import com.example.order.model.Order;
import com.example.order.repository.OrderRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Service
public class OrderService {

    private final OrderRepository orderRepository;

    @Transactional
    public Order save(OrderRequestDTO orderDTO) {
        var order = Order.builder()
                .clientId(orderDTO.clientId())
                .build();
        orderRepository.save(order);
        log.info("Place new order {}", order);
        return order;
    }

    public Order findById(UUID id) {
        log.info("Fetching order with id {}", id);
        return orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Resource not found!"));
    }
}
