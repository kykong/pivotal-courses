package io.springtrader.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringtraderConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringtraderConsumerApplication.class, args);
    }
}
