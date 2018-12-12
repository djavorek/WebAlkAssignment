package hu.uni.djavorek.controller;

import hu.uni.djavorek.dto.ListApplicationsResponse;
import hu.uni.djavorek.dto.SearchApplicationResponse;
import hu.uni.djavorek.model.Application;
import hu.uni.djavorek.model.ApplicationFilter;
import hu.uni.djavorek.service.WorkerService;
import hu.uni.djavorek.util.FilterFactory;
import hu.uni.djavorek.util.ApplicationListMarshaller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/worker/")
public class WorkerController {

    @Autowired
    private WorkerService workerService;

    public WorkerController(WorkerService workerService) {
        this.workerService = workerService;
    }

    @GetMapping("{applicantId}/searchApplications")
    public SearchApplicationResponse searchApplications(@PathVariable("applicantId") Long applicantId,
                                                       @RequestParam(value = "applicationId", required = false) String applicationId,
                                                       @RequestParam(value = "jobId", required = false) String jobId,
                                                       @RequestParam(value = "createdAfter", required = false) String createdAfter,
                                                       @RequestParam(value = "createdBefore", required = false) String createdBefore,
                                                       @RequestParam(value = "hasComment", required = false) String hasComment) {
        SearchApplicationResponse response = new SearchApplicationResponse();

        ApplicationFilter filter = FilterFactory.getApplicationFilter(applicationId, jobId, createdAfter, createdBefore, hasComment);
        Collection<Application> applicationList = workerService.searchApplications(applicantId, filter);
        response.setModel(ApplicationListMarshaller.marshal(applicationList));

        return response;
    }

    @GetMapping("{applicantId}/listApplications")
    public ListApplicationsResponse listApplications(@PathVariable("applicantId") Long applicantId) {
        ListApplicationsResponse response = new ListApplicationsResponse();

        Collection<Application> applicationList = workerService.listApplications(applicantId);
        response.setModel(ApplicationListMarshaller.marshal(applicationList));

        return response;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalArgumentException.class)
    public void illegalArgument(){}
}