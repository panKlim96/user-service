package ru.teachbase.go.service;

import ru.teachbase.go.model.UserCriteriaFilter;
import ru.teachbase.go.model.UserResponse;
import ru.teachbase.go.model.PageUserResponse;
import ru.teachbase.go.model.UserRequest;

public interface UserService {

    void createUser(UserRequest userRequest);

    void deleteUserById(Integer id);

    UserResponse getUserById(Integer id);

    void updateUser(UserRequest updateUser);

    PageUserResponse getUserByFilter(UserCriteriaFilter userCriteriaFilter);
}
