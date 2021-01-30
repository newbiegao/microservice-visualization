package org.keron.microservicevisualization.service;

import org.keron.microservicevisualization.entity.DepartmentEntity;
import org.keron.microservicevisualization.repository.DepartmentRepository;
import org.keron.microservicevisualization.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository ;

    @Autowired
    private ProductRepository productRepository ;

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
    public DepartmentEntity loadDepartmentEntityAndProducts( Integer deptId ){

        DepartmentEntity departmentEntity =  departmentRepository.loadDepartmentEntity(deptId) ;

        // load products
        departmentEntity.getProductEntityList().addAll(productRepository.loadProductEntityByDeptId(deptId)) ;

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
            departmentEntity.getProductEntityList().addAll(productRepository.loadProductEntityByDeptId(departmentEntity.getId())) ;
        }

        return departmentEntityList ;
    }

}
