package ru.teachbase.go.base;


import io.restassured.module.mockmvc.RestAssuredMockMvc;
import lombok.Setter;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import ru.teachbase.go.controller.UserController;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@ActiveProfiles("test-contracts")
public class BaseContractTest {

    @Setter(onMethod_ = { @Autowired})
    UserController userController;

    @BeforeEach
    public void setup() {
//        Server.createWebServer("-web", "-webAllowOthers", "-webPort", "8083")
//                .start();
        RestAssuredMockMvc.standaloneSetup(userController);
    }
}
