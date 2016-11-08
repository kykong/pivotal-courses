package io.springtrader.producer;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class ProducerController {

    private org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(ProducerController.class);
    private AtomicInteger counter = new AtomicInteger(0);

    @RequestMapping("counter-value")
    public Object produce() {
        int value = counter.getAndIncrement();
        log.info("Produced a value: {}", value);

        return Collections.singletonMap("value", value);
    }

}
