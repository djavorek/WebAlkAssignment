package hu.uni.djavorek.service.config;

import hu.uni.djavorek.service.OperatorService;
import hu.uni.djavorek.service.OperatorServiceImpl;
import hu.uni.djavorek.service.WorkerService;
import hu.uni.djavorek.service.WorkerServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {

    @Bean
    public OperatorService operatorService() {
        return new OperatorServiceImpl();
    }

    @Bean
    public WorkerService workerService() {
        return new WorkerServiceImpl();
    }
}
