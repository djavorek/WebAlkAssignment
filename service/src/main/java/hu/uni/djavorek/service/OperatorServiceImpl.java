package hu.uni.djavorek.service;

import hu.uni.djavorek.dao.ApplicationDao;
import hu.uni.djavorek.dao.JobDao;
import hu.uni.djavorek.model.Application;
import hu.uni.djavorek.model.Job;
import hu.uni.djavorek.model.exception.JobAlreadyExistsException;

import java.util.Collection;
import java.util.List;

public class OperatorServiceImpl implements OperatorService {

    private final JobDao jobDao;
    private final ApplicationDao applicationDao;

    public OperatorServiceImpl(JobDao jobDao, ApplicationDao applicationDao) {
        this.jobDao = jobDao;
        this.applicationDao = applicationDao;
    }

    @Override
    public void advertiseJob(Job jobToAdvertise) {
        List<Job> jobsWithSameName = jobDao.findAllByName(jobToAdvertise.getName());

        if (jobsWithSameName != null && jobsWithSameName.size() > 0) {
            for (Job jobToCheck : jobsWithSameName) {
                if (jobToCheck.equals(jobToAdvertise)) {
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
