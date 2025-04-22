package com.example.order.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(name = "api-gateway", path = "/user")
public interface UserFeignClient {

    @GetMapping(path= "/{id}")
    UserDTO findById(@PathVariable UUID id);
}
