package hu.uni.djavorek.service;

import hu.uni.djavorek.dao.ApplicationDao;
import hu.uni.djavorek.dao.JobDao;
import hu.uni.djavorek.dto.AdvertiseJobRequest;
import hu.uni.djavorek.dto.AdvertiseJobResponse;
import hu.uni.djavorek.model.Application;
import hu.uni.djavorek.model.Job;
import hu.uni.djavorek.model.JobType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class OperatorServiceImpl implements OperatorService {

    @Autowired
    private JobDao jobDao;
    @Autowired
    private ApplicationDao applicationDao;

    @Override
    public AdvertiseJobResponse advertiseJob(AdvertiseJobRequest advertiseJobRequest) {
        AdvertiseJobResponse response = new AdvertiseJobResponse();
        hu.uni.djavorek.dto.Job requestedJob = advertiseJobRequest.getJob();
        response.setModel(requestedJob);

        Job jobToAdvertise = new Job(requestedJob.getName(), JobType.valueOf(requestedJob.getType().value()), requestedJob.getCity(), requestedJob.getWage(), requestedJob.getDescription(),requestedJob.getRequirements().getRequirement());
        jobDao.save(jobToAdvertise);
        return response;
    }

    @Override
    public Collection<Application> listApplications() {
        return applicationDao.findAll();
    }
}
