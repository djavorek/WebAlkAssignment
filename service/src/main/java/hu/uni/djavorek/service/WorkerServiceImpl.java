package hu.uni.djavorek.service;

import hu.uni.djavorek.dao.ApplicationDao;
import hu.uni.djavorek.model.Application;
import hu.uni.djavorek.model.ApplicationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Collection;
import java.util.List;

public class WorkerServiceImpl implements WorkerService {

    @Autowired
    private ApplicationDao applicationDao;

    @Override
    public Collection<Application> searchApplications(Long applicantId, ApplicationFilter applicationFilter) {
        return filterApplications(applicationDao.findAllByApplicantId(applicantId), applicationFilter);
    }

    @Override
    public Collection<Application> listApplications(Long applicantId) {
        return applicationDao.findAllByApplicantId(applicantId);
    }

    private List<Application> filterApplications(List<Application> applicationList, ApplicationFilter filter) {
        if(filter.getApplicationid() != null) {
            for(Application application : applicationList) {
                if(filter.getApplicationid() != application.getId()) {
                    applicationList.remove(application);
                }
            }
        }
        if(filter.getJobId() != null) {
            for(Application application : applicationList) {
                if(filter.getJobId() != application.getJobId()) {
                    applicationList.remove(application);
                }
            }
        }
        if(filter.getHasComment() != null) {
            for(Application application : applicationList) {
                if(filter.getHasComment() == true) {
                    if(application.getComment() == null || application.getComment().length() == 0) {
                        applicationList.remove(application);
                    }
                }
                else if(filter.getHasComment() == false) {
                    if(application.getComment() != null && application.getComment().length() > 0) {
                        applicationList.remove(application);
                    }
                }
            }
        }
        if(filter.getCreatedAfter() != null) {
            for (Application application : applicationList) {
                if (filter.getCreatedAfter().compareTo(application.getCreationDate()) > 0) {
                    applicationList.remove(application);
                }
            }
        }
        if(filter.getCreatedBefore() != null) {
            for(Application application : applicationList) {
                if(filter.getCreatedBefore().compareTo(application.getCreationDate()) < 0) {
                    applicationList.remove(application);
                }
            }
        }

        return applicationList;
    }
}
