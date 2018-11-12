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
    private Job job;
    private Applicant applicant;
    private Calendar creationDate;
    private String comment;

    protected Application() {}

    public Application(Job job, Applicant applicant, Calendar creationDate, String comment) {
        this.job = job;
        this.applicant = applicant;
        this.creationDate = creationDate;
        this.comment = comment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Job getJob() {
        return job;
    }

    public void setJobId(Job job) {
        this.job = job;
    }

    public Applicant getApplicant() {
        return applicant;
    }

    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
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
