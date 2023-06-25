package ru.teachbase.go.userGateway.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.teachbase.go.userGateway.feign.UserServiceClient;
import ru.teachbase.go.model.UserResponse;

@RestController
@RequestMapping("/user/gateway")
@RequiredArgsConstructor
public class UserGatewayController {
    private final UserServiceClient userServiceClient;
    @GetMapping("/getUserById/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable("id") Integer id) {
        ResponseEntity<UserResponse> user = userServiceClient.getUserById(id);
        return user;
    }
}
