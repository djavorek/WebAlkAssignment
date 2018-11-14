package hu.uni.djavorek.controller;

import hu.uni.djavorek.dto.*;
import hu.uni.djavorek.model.Application;
import hu.uni.djavorek.model.Job;
import hu.uni.djavorek.model.JobType;
import hu.uni.djavorek.model.exception.JobAlreadyExistsException;
import hu.uni.djavorek.service.OperatorService;
import hu.uni.djavorek.util.ApplicationListMarshaller;
import hu.uni.djavorek.util.CalendarConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/operator/")
public class OperatorController {

    private static Logger LOGGER = LoggerFactory.getLogger(OperatorController.class);
    private OperatorService operatorService;

    public OperatorController(OperatorService operatorService) {
        this.operatorService = operatorService;
    }

    @PostMapping("addJob")
    public AdvertiseJobResponse advertiseJob(@RequestBody AdvertiseJobRequest request) {
        hu.uni.djavorek.dto.Job requestedJob = request.getJob();
        Job jobToAdvertise = new Job(requestedJob.getName(), JobType.valueOf(requestedJob.getType().value()),
                requestedJob.getCity(), requestedJob.getWage(), requestedJob.getDescription(), requestedJob.getRequirements().getRequirement());


        operatorService.advertiseJob(jobToAdvertise);

        AdvertiseJobResponse response = new AdvertiseJobResponse();
        response.setModel(requestedJob);

        return response;
    }

    @GetMapping("listApplication")
    public ListApplicationResponse listApplication() {
        ListApplicationResponse response = new ListApplicationResponse();

        Collection<Application> applicationList = operatorService.listApplications();
        response.setModel(ApplicationListMarshaller.marshal(applicationList));
        return response;
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(JobAlreadyExistsException.class)
    public void alreadyExistingJob() {}

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(IllegalStateException.class)
    public void illegalState(){}
}
