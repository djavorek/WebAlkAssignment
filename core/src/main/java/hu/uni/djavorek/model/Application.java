package hu.uni.djavorek.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Calendar;

@Entity
public class Application {

    @Id
    @GeneratedValue
    private Long id;
    private Long jobId;
    private Long applicantId;
    private Calendar creationDate;
    private String comment;

    protected Application() {}

    public Application(Long jobId, Long applicantId, Calendar creationDate, String comment) {
        this.jobId = jobId;
        this.applicantId = applicantId;
        this.creationDate = creationDate;
        this.comment = comment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public Long getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(Long applicantId) {
        this.applicantId = applicantId;
    }

    public Calendar getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Calendar creationDate) {
        this.creationDate = creationDate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
