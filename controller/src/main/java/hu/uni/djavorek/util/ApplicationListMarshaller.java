package hu.uni.djavorek.util;

import hu.uni.djavorek.dto.ApplicationListModel;
import hu.uni.djavorek.model.Applicant;
import hu.uni.djavorek.model.Application;
import hu.uni.djavorek.model.Job;
import hu.uni.djavorek.model.JobType;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ApplicationListMarshaller {

    public static ApplicationListModel marshal(Collection<Application> applicationList) {
        ApplicationListModel applicationListModel = new ApplicationListModel();

        for (Application application : applicationList) {
            hu.uni.djavorek.dto.JobRequirements jobRequirementsResponseEntity = new hu.uni.djavorek.dto.JobRequirements();
            jobRequirementsResponseEntity.getRequirement().addAll(application.getJob().getRequirements());

            hu.uni.djavorek.dto.Job jobResponseEntity = new hu.uni.djavorek.dto.Job();
            jobResponseEntity.setRequirements(jobRequirementsResponseEntity);
            jobResponseEntity.setType(hu.uni.djavorek.dto.JobType.valueOf(application.getJob().getType().name()));
            BeanUtils.copyProperties(application.getJob(), jobResponseEntity);

            hu.uni.djavorek.dto.Applicant applicantResponseEntity = new hu.uni.djavorek.dto.Applicant();
            BeanUtils.copyProperties(application.getApplicant(), applicantResponseEntity);

            hu.uni.djavorek.dto.Application applicationResponseEntity = new hu.uni.djavorek.dto.Application();
            applicationResponseEntity.setJob(jobResponseEntity);
            applicationResponseEntity.setApplicant(applicantResponseEntity);
            applicationResponseEntity.setCreationDate(CalendarConverter.marshal(application.getCreationDate()));
            applicationResponseEntity.setComment(application.getComment());

            applicationListModel.getApplication().add(applicationResponseEntity);
        }

        return applicationListModel;
    }

    public static List<Application> unmarshal(ApplicationListModel applicationListModel) {
        List<Application> applicationList = new ArrayList<>();

        for (hu.uni.djavorek.dto.Application applicationDto : applicationListModel.getApplication()) {
            hu.uni.djavorek.dto.Job jobDto = applicationDto.getJob();
            Job job = new Job(jobDto.getName(), JobType.valueOf(jobDto.getType().name()), jobDto.getCity(), jobDto.getWage(), jobDto.getDescription(), jobDto.getRequirements().getRequirement());

            hu.uni.djavorek.dto.Applicant applicantDto = applicationDto.getApplicant();
            Applicant applicant = new Applicant(applicantDto.getFirstname(), applicantDto.getLastname(), applicantDto.getEmail(), applicantDto.getPhonenumber());

            Application application = new Application(job, applicant, CalendarConverter.unmarshal(applicationDto.getCreationDate()), applicationDto.getComment());
            applicationList.add(application);
        }
        return applicationList;
    }
}
