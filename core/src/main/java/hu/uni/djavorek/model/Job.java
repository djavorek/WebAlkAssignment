package hu.uni.djavorek.model;

import java.util.Collection;

public class Job {
    private Long id;
    private String name;
    private JobType type;
    private String city;
    private Integer wage;
    private String description;
    private Collection<String> requirements;

    protected Job(){}

    public Job(Long id, String name, JobType type, String city, Integer wage, String description, Collection<String> requirements) {
        this.id = id;
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

    public Collection<String> getRequirements() {
        return requirements;
    }

    public void setRequirements(Collection<String> requirements) {
        this.requirements = requirements;
    }
}
