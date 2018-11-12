package hu.uni.djavorek.dao;

import hu.uni.djavorek.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public interface JobDao extends JpaRepository<Job, Long> {

    List<Job> findAllByName(String name);
}
