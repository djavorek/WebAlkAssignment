package hu.uni.djavorek.dao;

import hu.uni.djavorek.model.Application;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApplicationDao extends JpaRepository<Application, Long> {

    //"SELECT * FROM Application WHERE Application.applicantId = :applicantId"
    List<Application> findAllByApplicantId(Long applicantId);
}
