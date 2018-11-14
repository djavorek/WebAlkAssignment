package hu.uni.djavorek.model;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class ApplicationFilter {
    private Long applicationId;
    private Long jobId;
    private Calendar createdAfter;
    private Calendar createdBefore;
    private Boolean hasComment;

    public ApplicationFilter(){}

    public ApplicationFilter(Long applicationId, Long jobId, Calendar createdAfter, GregorianCalendar createdBefore, Boolean hasComment) {
        this.applicationId = applicationId;
        this.jobId = jobId;
        this.createdAfter = createdAfter;
        this.createdBefore = createdBefore;
        this.hasComment = hasComment;
    }

    public Long getApplicationid() {
        return applicationId;
    }

    public ApplicationFilter setApplicationid(Long applicationId) {
        this.applicationId = applicationId;
        return this;
    }

    public Long getJobId() {
        return jobId;
    }

    public ApplicationFilter setJobId(Long jobId) {
        this.jobId = jobId;
        return this;
    }

    public Calendar getCreatedAfter() {
        return createdAfter;
    }

    public ApplicationFilter setCreatedAfter(Calendar createdAfter) {
        this.createdAfter = createdAfter;
        return this;
    }

    public Calendar getCreatedBefore() {
        return createdBefore;
    }

    public ApplicationFilter setCreatedBefore(Calendar createdBefore) {
        this.createdBefore = createdBefore;
        return this;
    }

    public Boolean getHasComment() {
        return hasComment;
    }

    public ApplicationFilter setHasComment(Boolean hasComment) {
        this.hasComment = hasComment;
        return this;
    }
}
