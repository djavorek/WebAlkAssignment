package web.config;

import hu.uni.djavorek.controller.OperatorController;
import hu.uni.djavorek.controller.config.ControllerConfig;
import hu.uni.djavorek.dao.config.DaoConfig;
import hu.uni.djavorek.service.OperatorService;

import hu.uni.djavorek.service.config.ServiceConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@ComponentScan({"web.config", "hu.uni.djavorek"})
@Configuration
@Import({DaoConfig.class, ServiceConfig.class, ControllerConfig.class})
public class ApplicationConfig {
}
