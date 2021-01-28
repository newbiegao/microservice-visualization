package org.keron.microservicevisualization.service;

import org.keron.microservicevisualization.entity.DepartmentEntity;
import org.keron.microservicevisualization.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository ;

    public List<DepartmentEntity> loadAllDepartments(){
        return departmentRepository.loadAllDepartment() ;
    }

}
