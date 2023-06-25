package ru.teachbase.go.userGateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityFilterAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(exclude = {SecurityFilterAutoConfiguration.class, DataSourceAutoConfiguration.class})
@EnableFeignClients
public class UserGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserGatewayApplication.class, args);
    }

}
