package ru.teachbase.go.userGateway.base;


import io.restassured.module.mockmvc.RestAssuredMockMvc;
import lombok.Setter;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.test.context.ActiveProfiles;
import ru.teachbase.go.userGateway.controller.UserGatewayController;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@ActiveProfiles("test-contracts")
@AutoConfigureStubRunner(ids = {
        "ru.teachbase.go:user-app-stubs:::9085"
}, stubsMode = StubRunnerProperties.StubsMode.LOCAL, repositoryRoot = "C:\\Users\\Klim\\MavenRepo")
public class BaseContractTest {

    @Setter(onMethod_ = { @Autowired})
    UserGatewayController userController;

    @BeforeEach
    public void setup() {
        RestAssuredMockMvc.standaloneSetup(userController);
    }
}
