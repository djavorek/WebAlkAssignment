package hu.uni.djavorek.service;

import hu.uni.djavorek.model.Application;
import hu.uni.djavorek.model.ApplicationFilter;

import java.util.Collection;
import java.util.GregorianCalendar;

public interface WorkerService {
    Collection<Application> searchApplications(ApplicationFilter applicationFilter);
    Collection<Application> listApplications();
}
