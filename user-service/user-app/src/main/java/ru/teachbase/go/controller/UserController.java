package ru.teachbase.go.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.teachbase.go.api.UserApi;
import ru.teachbase.go.model.PageUserResponse;
import ru.teachbase.go.model.UserCriteriaFilter;
import ru.teachbase.go.model.UserRequest;
import ru.teachbase.go.model.UserResponse;
import ru.teachbase.go.service.UserService;

@Slf4j
@RequiredArgsConstructor
@RestController
public class UserController implements UserApi {

    private final UserService userService;

    @Override
    public ResponseEntity<Void> createUser(UserRequest userRequest) {
        userService.createUser(userRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> deleteUserById(Integer id) {
        userService.deleteUserById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<PageUserResponse> getUserByFilter(UserCriteriaFilter userCriteriaFilter) {
        return new ResponseEntity<>(userService.getUserByFilter(userCriteriaFilter), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<UserResponse> getUserById(Integer id) {
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
    }
}
