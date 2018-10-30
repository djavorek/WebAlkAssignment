package hu.uni.djavorek.controller;

import hu.uni.djavorek.model.Job;
import hu.uni.djavorek.model.JobType;
import hu.uni.djavorek.service.OperatorService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/operator/")
public class OperatorController {

    private OperatorService operatorService;

    public OperatorController(OperatorService operatorService) {
        this.operatorService = operatorService;
    }

    @GetMapping("addJob")
    @ResponseBody
    public void addJob() {
        Job dummyJob = new Job(null, "Dummy Seprés", JobType.MANUFACTURING, "Sorsod Borsod", 1000, "", null);
        operatorService.advertiseJob(dummyJob);
    }
}
