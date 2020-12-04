package com.epam.yoke.event.actuator;

import com.epam.yoke.event.model.rs.NotifyEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class YokeNotifierHealthIndicator implements HealthIndicator {

    @Value("${yoke.notify.url}")
    private String notifierUrl;

    @Autowired
    @LoadBalanced
    private RestTemplate restTemplate;

    @Override
    public Health health() {
        int code = getStatus();
        if (code != 200) {
            return Health.down().build();
        }
        return Health.up().build();
    }

    private int getStatus() {
        int code;
        try {
            code = restTemplate.getForEntity(notifierUrl + "/", NotifyEvent[].class).getStatusCode().value();
        } catch (Exception e) {
            return -1;
        }
        return code;
    }

}