package org.keron.microservicevisualization;

import org.junit.jupiter.api.Test;
import org.keron.microservicevisualization.entity.ProductEntity;
import org.keron.microservicevisualization.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ProductServiceTest {

    @Autowired
    private ProductService productService ;

    @Test
    public void loadProductEntityAndSystemEntityTest(){

        Integer proId = 1 ;
        ProductEntity productEntity =   productService.loadProductEntityAndSystemEntity(proId) ;

        assertThat(productEntity).isNotNull() ;
        assertThat(productEntity.getSystemEntityList()).isNotEmpty() ;

    }

}
