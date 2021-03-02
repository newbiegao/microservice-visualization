package org.keron.microservicevisualization.service;

import org.keron.microservicevisualization.entity.DepartmentEntity;
import org.keron.microservicevisualization.entity.ProductEntity;
import org.keron.microservicevisualization.repository.DepartmentRepository;
import org.keron.microservicevisualization.repository.ProductRepository;
import org.keron.microservicevisualization.repository.SystemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository ;

    @Autowired
    private ProductRepository productRepository ;

    @Autowired
    private SystemRepository systemRepository ;

    /**
     *
     * @return
     */
    public List<DepartmentEntity> loadAllDepartments(){
        return departmentRepository.loadAllDepartment() ;
    }

    /**
     *
     * @param deptId
     * @return
     */
    public DepartmentEntity loadDepartment( Integer deptId ){
        return departmentRepository.loadDepartmentEntity(deptId) ;
    }

    /**
     *
     * @param deptId
     * @return
     */
    public DepartmentEntity loadDepartmentEntityAndProducts( Integer deptId ){

        DepartmentEntity departmentEntity =  departmentRepository.loadDepartmentEntity(deptId) ;

        // load products
        List<ProductEntity> productEntityList = productRepository.loadProductEntityListByDeptId(departmentEntity.getId()) ;
        for( ProductEntity productEntity :  productEntityList) {
            productEntity.getSystemEntityList().addAll(systemRepository.loadSystemEntityListByProId(productEntity.getId())) ;
        }
        departmentEntity.getProductEntityList().addAll(productEntityList) ;

        return departmentEntity ;
    }

    /**
     *
     * @return
     */
    public List<DepartmentEntity> loadAllDepartmentEntityAndProducts(){

        List<DepartmentEntity> departmentEntityList = departmentRepository.loadAllDepartment() ;

        // load products
        for( DepartmentEntity departmentEntity : departmentEntityList ){
            List<ProductEntity> productEntityList = productRepository.loadProductEntityListByDeptId(departmentEntity.getId()) ;
            departmentEntity.getProductEntityList().addAll(productEntityList) ;
        }

        return departmentEntityList ;
    }

    /**
     *
     * @param deptId
     * @param deptName
     * @return
     */
    public DepartmentEntity saveDept( Integer deptId , String deptName ){

        DepartmentEntity departmentEntity =  departmentRepository.loadDepartmentEntity( deptId ) ;
        if( departmentEntity == null ) {
            departmentEntity = new DepartmentEntity() ;
            departmentEntity.setId(deptId);
        }
        departmentEntity.setName(deptName);
        departmentRepository.saveAndFlush(departmentEntity) ;
        return departmentEntity ;
    }

    /**
     *
     * @param deptId
     * @return
     */
    public boolean deleteDept( Integer deptId ){

        // check has products
        if( productRepository.loadDeptProductCounts(deptId) > 0 ){
            return false ;
        }
        departmentRepository.deleteDepartmentEntity(deptId);
        return true ;
    }

    public Integer loadNextDeptId(){
       return departmentRepository.findMaxDeptId() + 1 ;
    }

}
