package org.keron.microservicevisualization.controls;

import org.keron.microservicevisualization.entity.ProductEntity;
import org.keron.microservicevisualization.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductChartControler {

    @Autowired
    private ProductService productService ;

    @GetMapping("/data/pros/{deptId}")
    public List<ProductEntity>loadDeptChart(@PathVariable Integer deptId ){

        if( deptId < 0 ) return new ArrayList<>() ;
        return productService.loadProductEntityListByDeptId(deptId) ;

    }
}
