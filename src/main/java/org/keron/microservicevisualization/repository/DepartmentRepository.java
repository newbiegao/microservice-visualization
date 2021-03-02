package org.keron.microservicevisualization.repository;

import org.keron.microservicevisualization.entity.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface DepartmentRepository extends JpaRepository<DepartmentEntity , Integer> {

    @Query(" from DepartmentEntity ")
    List<DepartmentEntity> loadAllDepartment() ;

    @Query(" from DepartmentEntity d where d.id = :deptId ")
    DepartmentEntity loadDepartmentEntity(@Param("deptId") Integer deptId ) ;

    @Modifying
    @Query(" delete from DepartmentEntity d where d.id = :deptId ")
    void deleteDepartmentEntity(@Param("deptId") Integer deptId ) ;

    @Query(" select max(d.id) from DepartmentEntity d ")
    Integer findMaxDeptId() ;

}
