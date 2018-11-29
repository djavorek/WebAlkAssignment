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

    private final ApplicationDao applicationDao;

    @Autowired
    public WorkerServiceImpl(ApplicationDao applicationDao) {
        this.applicationDao = applicationDao;
    }

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
            applicationList.removeIf(application -> filter.getApplicationid() != application.getId());
        }
        if(filter.getJobId() != null) {
            applicationList.removeIf(application -> filter.getJobId() != application.getJob().getId());
        }
        if(filter.getHasComment() != null) {
            Iterator<Application> iterator = applicationList.iterator();
            while(iterator.hasNext()) {
                Application application = iterator.next();
                if(filter.getHasComment()) {
                    if(application.getComment() == null || application.getComment().length() == 0) {
                        iterator.remove();
                    }
                }
                else if(!filter.getHasComment()) {
                    if(application.getComment() != null && application.getComment().length() > 0) {
                        iterator.remove();
                    }
                }
            }
        }
        if(filter.getCreatedAfter() != null) {
            applicationList.removeIf(application -> filter.getCreatedAfter().compareTo(application.getCreationDate()) > 0);
        }
        if(filter.getCreatedBefore() != null) {
            applicationList.removeIf(application -> filter.getCreatedBefore().compareTo(application.getCreationDate()) < 0);
        }

        return applicationList;
    }
}
