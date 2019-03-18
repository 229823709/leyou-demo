package com.leyou.parent.leyou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication

public class LeyouApplication {

    public static void main(String[] args) {
        SpringApplication.run(LeyouApplication.class, args);
    }

}
