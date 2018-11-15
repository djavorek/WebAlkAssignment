package hu.uni.djavorek.web.config;

import hu.uni.djavorek.controller.config.ControllerConfig;
import hu.uni.djavorek.dao.config.DaoConfig;
import hu.uni.djavorek.service.config.ServiceConfig;
import org.springframework.context.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@ComponentScan("hu.uni.djavorek")
@Configuration
@Import({DaoConfig.class, ServiceConfig.class, ControllerConfig.class})
public class ApplicationConfig {}
