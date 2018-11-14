package hu.uni.djavorek.controller;

import hu.uni.djavorek.dto.ApplicationFilter;
import hu.uni.djavorek.dto.SearchApplicationRequest;
import hu.uni.djavorek.dto.SearchApplicationResponse;
import hu.uni.djavorek.model.Application;
import hu.uni.djavorek.service.WorkerService;
import hu.uni.djavorek.util.ApplicationFilterUnmarshaller;
import hu.uni.djavorek.util.ApplicationListMarshaller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/worker/")
public class WorkerController {

    private static Logger LOGGER = LoggerFactory.getLogger(OperatorController.class);
    private WorkerService workerService;

    public WorkerController(WorkerService workerService) {
        this.workerService = workerService;
    }

    @GetMapping("{applicantId}/searchApplications")
    public SearchApplicationResponse filterApplication(@PathVariable("applicantId") Long applicantId, @RequestBody SearchApplicationRequest request) {
        SearchApplicationResponse response = new SearchApplicationResponse();

        ApplicationFilter filter = request.getFilter();
        Collection<Application> applicationList = workerService.searchApplications(applicantId, ApplicationFilterUnmarshaller.unmarshal(filter));
        response.setModel(ApplicationListMarshaller.marshal(applicationList));

        return response;
    }
}