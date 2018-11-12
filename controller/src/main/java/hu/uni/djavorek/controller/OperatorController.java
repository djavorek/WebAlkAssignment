package hu.uni.djavorek.controller;

import hu.uni.djavorek.dto.*;
import hu.uni.djavorek.model.Application;
import hu.uni.djavorek.model.Job;
import hu.uni.djavorek.model.JobType;
import hu.uni.djavorek.model.exception.JobAlreadyExistsException;
import hu.uni.djavorek.service.OperatorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.Collection;
import java.util.GregorianCalendar;

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
        DatatypeFactory xmlGregorianCalendarFactory = null;

        try {
            xmlGregorianCalendarFactory = DatatypeFactory.newInstance();
        } catch (DatatypeConfigurationException e) {
            LOGGER.warn("DatatypeConfigurationException occured, cannot create response message");
            throw new IllegalStateException();
        }

        Collection<Application> applicationList = operatorService.listApplications();
        ApplicationListModel applicationListModel = new ApplicationListModel();

        for(Application application : applicationList) {
            hu.uni.djavorek.dto.Job jobResponseEntity = new hu.uni.djavorek.dto.Job();
            jobResponseEntity.setName(application.getJob().getName());
            jobResponseEntity.setType(hu.uni.djavorek.dto.JobType.valueOf(application.getJob().getType().name()));
            jobResponseEntity.setCity(application.getJob().getCity());
            jobResponseEntity.setWage(application.getJob().getWage());
            jobResponseEntity.setDescription(application.getJob().getDescription());

            hu.uni.djavorek.dto.Applicant applicantResponseEntity = new hu.uni.djavorek.dto.Applicant();
            applicantResponseEntity.setFirstname(application.getApplicant().getFirstname());
            applicantResponseEntity.setLastname(application.getApplicant().getLastname());
            applicantResponseEntity.setEmail(application.getApplicant().getEmail());
            applicantResponseEntity.setPhonenumber(application.getApplicant().getPhonenumber());

            GregorianCalendar gregorianCalendar = new GregorianCalendar();
            gregorianCalendar.setTimeInMillis(application.getCreationDate().getTimeInMillis());
            XMLGregorianCalendar creationDate = xmlGregorianCalendarFactory.newXMLGregorianCalendar(gregorianCalendar);

            hu.uni.djavorek.dto.Application applicationResponseEntity = new hu.uni.djavorek.dto.Application();
            applicationResponseEntity.setJob(jobResponseEntity);
            applicationResponseEntity.setApplicant(applicantResponseEntity);
            applicationResponseEntity.setCreationDate(creationDate);
            applicationResponseEntity.setComment(application.getComment());

            applicationListModel.getApplication().add(applicationResponseEntity);
        }
        response.setModel(applicationListModel);
        return response;
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(JobAlreadyExistsException.class)
    public void alreadyExistingJob() {
        LOGGER.warn("JobAlreadyExists - Exception");
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(IllegalStateException.class)
    public void illegalState() {
    }

}
