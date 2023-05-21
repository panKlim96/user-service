package ru.teachbase.go.facadeuser.base;


import io.restassured.module.mockmvc.RestAssuredMockMvc;
import lombok.Setter;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.test.context.ActiveProfiles;
import ru.teachbase.go.facadeuser.controller.UserFacadeController;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@ActiveProfiles("test-contracts")
@AutoConfigureStubRunner(ids = {
        "ru.teachbase.go.user-app::9080"
})
public class BaseContractTest {

    @Setter(onMethod_ = { @Autowired})
    UserFacadeController userController;

    @BeforeEach
    public void setup() {
        RestAssuredMockMvc.standaloneSetup(userController);
    }
}
