package org.keron.microservicevisualization.repository;

import org.keron.microservicevisualization.entity.LinkEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LinkRepository extends JpaRepository<LinkEntity, Integer> {



}
