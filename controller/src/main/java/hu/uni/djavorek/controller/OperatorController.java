package hu.uni.djavorek.controller;

import hu.uni.djavorek.model.Job;
import hu.uni.djavorek.model.JobType;
import hu.uni.djavorek.service.OperatorService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

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
        List<String> dummyReq = new ArrayList<>();
        dummyReq.add("Kitartás");
        dummyReq.add("3 év tapasztalat");
        Job dummyJob = new Job(null, "Pénz lapátolás", JobType.ACCOUNTING, "Avas", 1000, "Fun, fun, fun", dummyReq);
        operatorService.advertiseJob(dummyJob);
    }
}
