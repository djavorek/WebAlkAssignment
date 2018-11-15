package hu.uni.djavorek.service;

import hu.uni.djavorek.dao.ApplicationDao;
import hu.uni.djavorek.model.Application;
import hu.uni.djavorek.model.ApplicationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class WorkerServiceImpl implements WorkerService {

    @Autowired
    private ApplicationDao applicationDao;

    @Override
    public Collection<Application> searchApplications(Long applicantId, @Nullable ApplicationFilter applicationFilter) {
        if(applicationFilter == null) {
            applicationFilter = new ApplicationFilter();
        }
        return filterApplications(applicationDao.findAllByApplicantId(applicantId), applicationFilter);
    }

    @Override
    public Collection<Application> listApplications(Long applicantId) {
        return applicationDao.findAllByApplicantId(applicantId);
    }

    private List<Application> filterApplications(List<Application> applicationList, ApplicationFilter filter) {
        if(filter.getApplicationid() != null) {
            Iterator<Application> iterator = applicationList.iterator();
            while(iterator.hasNext()) {
                Application application = iterator.next();
                if(filter.getApplicationid() != application.getId()) {
                    iterator.remove();
                }
            }
        }
        if(filter.getJobId() != null) {
            Iterator<Application> iterator = applicationList.iterator();
            while(iterator.hasNext()) {
                Application application = iterator.next();
                if(filter.getJobId() != application.getJob().getId()) {
                    iterator.remove();
                }
            }
        }
        if(filter.getHasComment() != null) {
            Iterator<Application> iterator = applicationList.iterator();
            while(iterator.hasNext()) {
                Application application = iterator.next();
                if(filter.getHasComment() == true) {
                    if(application.getComment() == null || application.getComment().length() == 0) {
                        iterator.remove();
                    }
                }
                else if(filter.getHasComment() == false) {
                    if(application.getComment() != null && application.getComment().length() > 0) {
                        iterator.remove();
                    }
                }
            }
        }
        if(filter.getCreatedAfter() != null) {
            Iterator<Application> iterator = applicationList.iterator();
            while(iterator.hasNext()) {
                Application application = iterator.next();
                if (filter.getCreatedAfter().compareTo(application.getCreationDate()) > 0) {
                    iterator.remove();
                }
            }
        }
        if(filter.getCreatedBefore() != null) {
            Iterator<Application> iterator = applicationList.iterator();
            while(iterator.hasNext()) {
                Application application = iterator.next();
                if(filter.getCreatedBefore().compareTo(application.getCreationDate()) < 0) {
                    iterator.remove();
                }
            }
        }

        return applicationList;
    }
}
