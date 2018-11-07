package hu.uni.djavorek.dao;

import hu.uni.djavorek.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobDao extends JpaRepository<Job, Long> {
}
