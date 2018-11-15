package hu.uni.djavorek.controller.config;

import hu.uni.djavorek.controller.OperatorController;
import hu.uni.djavorek.controller.WorkerController;
import hu.uni.djavorek.service.OperatorService;
import hu.uni.djavorek.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

public class ControllerConfig {
    @Autowired
    private OperatorService operatorService;

    @Autowired
    private WorkerService workerService;

    @Bean
    public OperatorController operatorController() {
        return new OperatorController(operatorService);
    }

    @Bean
    public WorkerController workerController() {return  new WorkerController(workerService);}


}
