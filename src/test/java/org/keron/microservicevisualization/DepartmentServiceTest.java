package org.keron.microservicevisualization;

import org.junit.jupiter.api.Test;
import org.keron.microservicevisualization.entity.DepartmentEntity;
import org.keron.microservicevisualization.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService ;

    @Test
    public void loadAllDepartmentsTest(){

        List<DepartmentEntity> departmentEntityList =  departmentService.loadAllDepartments() ;

        assertThat(departmentEntityList).isNotEmpty() ;

    }
}
