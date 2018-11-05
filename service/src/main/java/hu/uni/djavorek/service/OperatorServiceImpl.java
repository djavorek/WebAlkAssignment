package hu.uni.djavorek.service;

import hu.uni.djavorek.dao.ApplicationDao;
import hu.uni.djavorek.dao.JobDao;
import hu.uni.djavorek.model.Application;
import hu.uni.djavorek.model.Job;
import hu.uni.djavorek.model.JobType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class OperatorServiceImpl implements OperatorService {

    @Autowired JobDao jobDao;
    @Autowired ApplicationDao applicationDao;

    @Override
    public void advertiseJob(Job job) {
        jobDao.save(job);
    }

    @Override
    public Collection<Application> listApplications() {
        return applicationDao.findAll();
    }
}
