package hu.uni.djavorek.web.config;

import hu.uni.djavorek.dao.ApplicationDao;
import hu.uni.djavorek.dao.JobDao;
import hu.uni.djavorek.service.OperatorService;
import hu.uni.djavorek.service.OperatorServiceImpl;
import hu.uni.djavorek.service.WorkerService;
import hu.uni.djavorek.service.WorkerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("hu.uni.djavorek.dao")
public class ServiceConfig {
    private final JobDao jobDao;
    private final ApplicationDao applicationDao;

    @Autowired
    public ServiceConfig(JobDao jobDao, ApplicationDao applicationDao) {
        this.jobDao = jobDao;
        this.applicationDao = applicationDao;
    }

    @Bean
    public OperatorService operatorService(){
        return new OperatorServiceImpl(jobDao, applicationDao);
    }

    @Bean
    public WorkerService workerService() {
        return new WorkerServiceImpl(applicationDao);
    }
}
