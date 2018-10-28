package hu.uni.djavorek.model;

import java.util.GregorianCalendar;

public class ApplicationFilter {
    private Long applicationid;
    private Long jobId;
    private Long applicantId;
    private GregorianCalendar createdAfter;
    private GregorianCalendar createdBefore;
    private Boolean hasComment;

    public ApplicationFilter(){}

    public ApplicationFilter(Long applicationid, Long jobId, Long applicantId, GregorianCalendar createdAfter, GregorianCalendar createdBefore, Boolean hasComment) {
        this.applicationid = applicationid;
        this.jobId = jobId;
        this.applicantId = applicantId;
        this.createdAfter = createdAfter;
        this.createdBefore = createdBefore;
        this.hasComment = hasComment;
    }

    public Long getApplicationid() {
        return applicationid;
    }

    public ApplicationFilter setApplicationid(Long applicationid) {
        this.applicationid = applicationid;
        return this;
    }

    public Long getJobId() {
        return jobId;
    }

    public ApplicationFilter setJobId(Long jobId) {
        this.jobId = jobId;
        return this;
    }

    public Long getApplicantId() {
        return applicantId;
    }

    public ApplicationFilter setApplicantId(Long applicantId) {
        this.applicantId = applicantId;
        return this;
    }

    public GregorianCalendar getCreatedAfter() {
        return createdAfter;
    }

    public ApplicationFilter setCreatedAfter(GregorianCalendar createdAfter) {
        this.createdAfter = createdAfter;
        return this;
    }

    public GregorianCalendar getCreatedBefore() {
        return createdBefore;
    }

    public ApplicationFilter setCreatedBefore(GregorianCalendar createdBefore) {
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
