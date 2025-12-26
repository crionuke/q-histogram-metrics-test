package org.acme;

import io.micrometer.core.annotation.Timed;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.concurrent.ThreadLocalRandom;

@ApplicationScoped
public class GreetingService {

    @Timed(value = "hello", histogram = true)
    public String hello() {
        try {
            Thread.sleep(ThreadLocalRandom.current().nextInt(0, 1000));
            return "Hello from Quarkus REST";
        } catch (Exception e) {
            return "Interrupted";
        }
    }
}
