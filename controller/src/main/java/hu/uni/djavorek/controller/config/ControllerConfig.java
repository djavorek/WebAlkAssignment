package hu.uni.djavorek.controller.config;

import hu.uni.djavorek.controller.OperatorController;
import hu.uni.djavorek.service.OperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

public class ControllerConfig {
    @Autowired
    OperatorService operatorService;

    @Bean
    public OperatorController operatorController() {
        return new OperatorController(operatorService);
    }
}
