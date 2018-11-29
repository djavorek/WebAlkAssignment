package hu.uni.djavorek.web.config;

import hu.uni.djavorek.controller.OperatorController;
import hu.uni.djavorek.controller.WorkerController;
import hu.uni.djavorek.service.OperatorService;
import hu.uni.djavorek.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("hu.uni.djavorek.web.config")
public class ControllerConfig {
    private final OperatorService operatorService;
    private final WorkerService workerService;

    @Autowired
    public ControllerConfig(OperatorService operatorService, WorkerService workerService) {
        this.operatorService = operatorService;
        this.workerService = workerService;
    }

    @Bean
    public OperatorController operatorController() {
        return new OperatorController(operatorService);
    }

    @Bean
    public WorkerController workerController() {
        return new WorkerController(workerService);
    }
}
