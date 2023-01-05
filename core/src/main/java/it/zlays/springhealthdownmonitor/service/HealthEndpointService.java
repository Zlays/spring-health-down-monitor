package it.zlays.springhealthdownmonitor.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import it.zlays.springhealthdownmonitor.data.HealthEntity;
import it.zlays.springhealthdownmonitor.repository.HealthRepository;
import it.zlays.springhealthdownmonitor.utils.Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.health.HealthComponent;
import org.springframework.boot.actuate.health.HealthEndpoint;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
@Slf4j
public class HealthEndpointService {

    @Value("${health.save.db:true}")
    private boolean saveOnDB;

    @Autowired
    private HealthEndpoint healthEndpoint;

    @Autowired
    private HealthRepository healthRepository;

    public HealthComponent health() throws JsonProcessingException {
        HealthComponent health = healthEndpoint.health();

        if (!health.getStatus().equals(Status.UP)) {
            String json = Utils.OW.writeValueAsString(health);
            log.warn("Health DOWN: ".concat(json));
            try {
                if (saveOnDB) {
                    healthRepository.save(new HealthEntity(null, json, LocalDateTime.now()));
                }
            } catch (Exception ignored) {
                // Ignore
            }
        }

        return health;
    }

}
