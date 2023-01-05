package it.zlays.springhealthdownmonitor.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadLocalRandom;

@Component
@ConditionalOnProperty(prefix = "health", name = "test.active", havingValue = "true")
public class RandomHealthIndicator implements HealthIndicator {

    @Value("${health.test.failure.percent:50}")
    private int failurePercent;

    @Override
    public Health health() {
        double chance = ThreadLocalRandom.current().nextDouble(0, 100);
        Health.Builder status = Health.up();
        if (chance < failurePercent) {
            status = Health.down();
        }
        return status.build();
    }
}
