package hu.uni.djavorek.dao;

import hu.uni.djavorek.model.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationDao extends JpaRepository<Application, Long> {
    //"SELECT * FROM Application WHERE Application.applicantId = :applicantId"
    List<Application> findAllByApplicantId(Long applicantId);
}
