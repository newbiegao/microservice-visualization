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

    /**
     *
     * @param deptId
     * @return
     */
    public List<ProductEntity> loadProductEntityListByDeptId( Integer deptId ){
        return productRepository.loadProductEntityListByDeptId(deptId) ;
    }

    public ProductEntity saveProductEntity( Integer deptId , Integer proId , String proName ){

        ProductEntity productEntity =  productRepository.loadProductEntityById(proId) ;
        if( productEntity == null ){
            productEntity = new ProductEntity() ;
            productEntity.setId(proId);
        }
        productEntity.setDeptId(deptId);
        productEntity.setName(proName);
        productRepository.saveAndFlush(productEntity) ;
        return productEntity  ;
    }

    public Boolean deletePro( Integer proId ){
        // check product has system
        Integer systemCount = systemRepository.loadSystemCount(proId) ;
        if ( systemCount > 0 ){
            return false ;
        }
        productRepository.deleteById( proId );
        return true ;
    }

    public Integer loadNextProductId(){
        return productRepository.loadMaxProductId() + 1 ;
    }

    /**
     *
     * @param deptId
     * @return
     */
    public Integer loadProductCount( Integer deptId ){
       return  productRepository.loadDeptProductCounts(deptId)  ;
    }

    /**
     *
     * @param proId
     * @return
     */
    public ProductEntity loadProductEntity( Integer proId ){
        return productRepository.loadProductEntityById(proId) ;
    }

}
