package org.keron.microservicevisualization.controls;

import org.keron.microservicevisualization.entity.ProductEntity;
import org.keron.microservicevisualization.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

    @PostMapping("/data/pro/save")
    public ProductEntity saveProductEntity( Integer deptId ,  Integer proId , String proName ){
        return  productService.saveProductEntity(deptId , proId , proName ) ;
    }

    @PostMapping("/data/pro/delete")
    public Boolean deleteProduct( Integer proId ){
        return productService.deletePro(proId) ;
    }

    @GetMapping("/data/pro/{proId}")
    public ProductEntity loadProductEntity( @PathVariable Integer proId ){
        return productService.loadProductEntity(proId) ;
    }
}
