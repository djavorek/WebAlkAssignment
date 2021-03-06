package hu.uni.djavorek.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Job {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private JobType type;
    private String city;
    private Integer wage;
    private String description;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> requirements;

    protected Job(){}

    public Job(String name, JobType type, String city, Integer wage, String description, List<String> requirements) {
        this.name = name;
        this.type = type;
        this.city = city;
        this.wage = wage;
        this.description = description;
        this.requirements = requirements;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public JobType getType() {
        return type;
    }

    public void setType(JobType type) {
        this.type = type;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getWage() {
        return wage;
    }

    public void setWage(Integer wage) {
        this.wage = wage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getRequirements() {
        return requirements;
    }

    public void setRequirements(List<String> requirements) {
        this.requirements = requirements;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return getName().equalsIgnoreCase(job.getName()) &&
                getCity().equalsIgnoreCase(job.getCity()) &&
                getWage().equals(job.getWage()) &&
                getType().name().equals(job.getType().name()) &&
                getDescription().equalsIgnoreCase(job.getDescription()) &&
                getRequirements().size() == job.getRequirements().size();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getType(), getCity(), getWage(), getDescription(), getRequirements());
    }
}
