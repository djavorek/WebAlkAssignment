package hu.uni.djavorek.service;

import hu.uni.djavorek.model.Application;
import hu.uni.djavorek.model.ApplicationFilter;
import java.util.Collection;


public interface WorkerService {
    Collection<Application> searchApplications(Long applicantId, ApplicationFilter applicationFilter);
    Collection<Application> listApplications(Long applicantId);
}
