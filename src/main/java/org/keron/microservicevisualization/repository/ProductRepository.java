package org.keron.microservicevisualization.repository;

import org.keron.microservicevisualization.entity.DepartmentEntity;
import org.keron.microservicevisualization.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity , Integer> {

    @Query(" from ProductEntity p where p.deptId = :deptId ")
    public List<ProductEntity> loadProductEntityByDeptId( @Param("deptId") Integer deptId ) ;

}
