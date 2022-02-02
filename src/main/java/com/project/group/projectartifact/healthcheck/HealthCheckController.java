package com.project.group.projectartifact.healthcheck;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/healthCheck")
public class HealthCheckController {

    private static  final Logger logger = LoggerFactory.getLogger(HealthCheckController.class);

    @GetMapping(value = "/status")
    public String getApplicationStatus() {
        logger.info("Application is running.");
        return HealthStatus.UP.toString();
    }

}
