package org.keron.microservicevisualization.repository;

import org.keron.microservicevisualization.entity.SystemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemRepository  extends JpaRepository<SystemEntity, Integer> {

}
