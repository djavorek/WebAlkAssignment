package hu.uni.djavorek.service;

import hu.uni.djavorek.dto.AdvertiseJobRequest;
import hu.uni.djavorek.dto.AdvertiseJobResponse;
import hu.uni.djavorek.model.Application;
import java.util.Collection;

public interface OperatorService {
    AdvertiseJobResponse advertiseJob(AdvertiseJobRequest advertiseJobRequest);
    Collection<Application> listApplications();
}
