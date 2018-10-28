package hu.uni.djavorek.service;

import hu.uni.djavorek.model.Application;
import hu.uni.djavorek.model.Job;

import java.util.Collection;

public interface OperatorService {
    void AdvertiseJob(Job job);
    Collection<Application> listApplications();
}
