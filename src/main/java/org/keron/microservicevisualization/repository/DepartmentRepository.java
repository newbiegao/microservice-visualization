package org.keron.microservicevisualization.repository;

import org.keron.microservicevisualization.entity.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentEntity , Integer> {

    @Query(" from DepartmentEntity ")
    public List<DepartmentEntity> loadAllDepartment() ;

}
