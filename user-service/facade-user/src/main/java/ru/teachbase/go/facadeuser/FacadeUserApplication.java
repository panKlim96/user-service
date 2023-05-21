package ru.teachbase.go.facadeuser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class FacadeUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(FacadeUserApplication.class, args);
    }

}
