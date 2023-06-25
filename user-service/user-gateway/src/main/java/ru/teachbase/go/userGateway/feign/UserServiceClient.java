package ru.teachbase.go.userGateway.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.teachbase.go.model.UserResponse;

@FeignClient(url = "${feign.user-app.url}",
        //path = "/api/v1/user/getUserById/{id}",
        name = "user-app")
public interface UserServiceClient {

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/api/v1/user/getUserById/{id}",
            produces = { "application/json" }
    )
    ResponseEntity<UserResponse> getUserById(@PathVariable("id") Integer id);
}
