package hu.uni.djavorek.dao;

import hu.uni.djavorek.model.Application;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationDao extends JpaRepository<Application, Long> {
}
