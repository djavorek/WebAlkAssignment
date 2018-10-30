package hu.uni.djavorek.dao;

import hu.uni.djavorek.model.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicantDao extends JpaRepository<Applicant, Long> {
}
