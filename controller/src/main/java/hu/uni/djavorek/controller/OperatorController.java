package hu.uni.djavorek.controller;

import hu.uni.djavorek.dto.AdvertiseJobRequest;
import hu.uni.djavorek.dto.AdvertiseJobResponse;
import hu.uni.djavorek.service.OperatorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/operator/")
public class OperatorController {

    private static Logger LOGGER = LoggerFactory.getLogger(OperatorController.class);
    private OperatorService operatorService;

    public OperatorController(OperatorService operatorService) {
        this.operatorService = operatorService;
    }

    @PostMapping(value = "addJob")
    public AdvertiseJobResponse advertiseJob(@RequestBody AdvertiseJobRequest advertiseJobRequest) {
        LOGGER.info("Advertise job request arrived");
        return operatorService.advertiseJob(advertiseJobRequest);
    }
}
