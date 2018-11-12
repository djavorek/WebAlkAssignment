package hu.uni.djavorek.service;

import hu.uni.djavorek.dao.ApplicationDao;
import hu.uni.djavorek.dao.JobDao;
import hu.uni.djavorek.model.Application;
import hu.uni.djavorek.model.Job;
import hu.uni.djavorek.model.exception.JobAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class OperatorServiceImpl implements OperatorService {

    @Autowired
    private JobDao jobDao;
    @Autowired
    private ApplicationDao applicationDao;

    @Override
    public void advertiseJob(Job jobToAdvertise) {
        List<Job> jobsWithSameName = jobDao.findAllByName(jobToAdvertise.getName());

        if(jobsWithSameName != null && jobsWithSameName.size() > 0) {
            for(Job jobToCheck : jobsWithSameName) {
                if(jobToCheck.equals(jobToAdvertise)) {
                    throw new JobAlreadyExistsException();
                }
            }
        }

        jobDao.save(jobToAdvertise);
    }

    @Override
    public Collection<Application> listApplications() {
        return applicationDao.findAll();
    }
}
