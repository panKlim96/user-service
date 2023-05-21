package ru.teachbase.go.facadeuser.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.teachbase.go.facadeuser.feign.UserServiceClient;
import ru.teachbase.go.model.UserResponse;

@RestController
@RequiredArgsConstructor
public class UserFacadeController {
    private final UserServiceClient userServiceClient;
    @GetMapping
    public ResponseEntity<UserResponse> getUserById(Integer id) {
        ResponseEntity<UserResponse> user = userServiceClient.getUserById(id);
        return user;
    }
}
