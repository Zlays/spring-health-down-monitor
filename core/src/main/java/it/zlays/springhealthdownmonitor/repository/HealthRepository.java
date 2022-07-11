package it.zlays.springhealthdownmonitor.repository;

import it.zlays.springhealthdownmonitor.data.HealthEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HealthRepository extends JpaRepository<HealthEntity, Long> {

}
