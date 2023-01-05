package it.zlays.springhealthdownmonitor.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;

@Component
@ConditionalOnProperty(prefix = "health", name = "test.active", havingValue = "true")
public class RandomHealthIndicator implements HealthIndicator {

    @Value("${health.test.failure.percent:50}")
    private int failurePercent;

    @Override
    public Health health() {
        SecureRandom random = new SecureRandom();
        random.nextBytes(new byte[20]);
        double chance = random.nextInt(100);
        Health.Builder status = Health.up();
        if (chance < failurePercent) {
            status = Health.down();
        }
        return status.build();
    }
}
