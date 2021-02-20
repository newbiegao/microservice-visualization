package org.keron.microservicevisualization.repository;

import org.keron.microservicevisualization.entity.SystemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface SystemRepository  extends JpaRepository<SystemEntity, Integer> {

    @Query(" from SystemEntity s where s.proId = :proId ")
    List<SystemEntity> loadSystemEntityListByProId( @Param("proId") Integer proId ) ;

    @Query(" from SystemEntity s where s.id = :sysId ")
    SystemEntity loadSystemEntity(@Param("sysId") Integer sysId ) ;

    @Query(" select count(*) from SystemEntity s where s.proId = :proId ")
    Integer loadSystemCount( @Param("proId") Integer proId ) ;

}
