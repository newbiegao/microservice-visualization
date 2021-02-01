package org.keron.microservicevisualization.repository;

import org.keron.microservicevisualization.entity.LinkEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LinkRepository extends JpaRepository<LinkEntity, Integer> {


    @Query( value = "from LinkEntity lk where lk.fromId in :fromIds " )
    List<LinkEntity> loadFromLinks(@Param("fromIds") List<Integer> nodeIds );

}
