package org.keron.microservicevisualization.repository;

import org.keron.microservicevisualization.entity.DepartmentEntity;
import org.keron.microservicevisualization.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface ProductRepository extends JpaRepository<ProductEntity , Integer> {

    @Query(" from ProductEntity p where p.deptId = :deptId ")
    List<ProductEntity> loadProductEntityListByDeptId( @Param("deptId") Integer deptId ) ;

    @Query(" from ProductEntity p where p.id = :id ")
    ProductEntity loadProductEntityById( @Param("id") Integer id ) ;

    @Query(" select count(*) from ProductEntity p where p.deptId = :deptId ")
    Integer loadDeptProductCounts( @Param("deptId") Integer deptI ) ;

    @Query(" select max(p.id) from ProductEntity p ")
    Integer loadMaxProductId( ) ;

}
