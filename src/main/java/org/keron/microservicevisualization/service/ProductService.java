package org.keron.microservicevisualization.service;

import org.keron.microservicevisualization.entity.ProductEntity;
import org.keron.microservicevisualization.entity.SystemEntity;
import org.keron.microservicevisualization.repository.ProductRepository;
import org.keron.microservicevisualization.repository.SystemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository ;

    @Autowired
    private SystemRepository systemRepository ;

    /**
     *
     * @param proId
     * @return
     */
    public ProductEntity loadProductEntityAndSystemEntity( Integer proId ){
        ProductEntity productEntity = productRepository.loadProductEntityById( proId ) ;

        // load systems
        List<SystemEntity> systemEntityList = systemRepository.loadSystemEntityListByProId(proId) ;
        productEntity.getSystemEntityList().addAll(systemEntityList) ;

        return productEntity ;
    }

}
