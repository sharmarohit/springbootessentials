package com.webware.boot.pacific.roomwebapp;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class DemoHealthIndicator implements HealthIndicator {
    @Override
    public Health health() {
        // add more complex checks here to determine up and down status
        return Health.up().withDetail("reason", "testing").build();
    }
}
