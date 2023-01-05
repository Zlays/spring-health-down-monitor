package it.zlays.springhealthdownmonitor.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import it.zlays.springhealthdownmonitor.service.HealthEndpointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.HealthComponent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("actuator")
public class DemoController {

    @Autowired
    private HealthEndpointService healthEndpointService;

    @GetMapping("health")
    public HealthComponent health() throws JsonProcessingException {
        return healthEndpointService.health();
    }

}
