package io.springtrader.consumer.controller;

import io.springtrader.consumer.ProducerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@RestController
public class ConsumerController {

    @Autowired
    DiscoveryClient discoveryClient;

    RestTemplate restTemplate = new RestTemplate();

    @RequestMapping("/")
    Object consume2() {
        ServiceInstance instance = discoveryClient.getInstances("PRODUCER").get(0);

        ProducerResponse response = restTemplate.getForObject(
                instance.getUri() + "/counter-value", ProducerResponse.class);

        return Collections.singletonMap("value", response.getValue());
    }

}
