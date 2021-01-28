package org.keron.microservicevisualization.repository;

import org.keron.microservicevisualization.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity , Integer> {

}
