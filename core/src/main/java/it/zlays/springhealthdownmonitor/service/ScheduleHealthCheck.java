package it.zlays.springhealthdownmonitor.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@ConditionalOnProperty(prefix = "health", name = "schedule.active", havingValue = "true")
@EnableScheduling
public class ScheduleHealthCheck {

    @Autowired
    private HealthEndpointService healthEndpointService;

    @Scheduled(fixedDelayString = "${health.schedule.fixed.delay:5000}", initialDelayString = "${health.schedule.initial.delay:5000}")
    public void scheduleFixedDelayTask() throws JsonProcessingException {
        log.debug("Check health");
        healthEndpointService.health();
    }

}
