package org.keron.microservicevisualization;

import org.junit.jupiter.api.Test;
import org.keron.microservicevisualization.entity.DepartmentEntity;
import org.keron.microservicevisualization.entity.ProductEntity;
import org.keron.microservicevisualization.model.flowcharts.Graph;
import org.keron.microservicevisualization.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class DepartmentServiceTest {

    private static Logger logger = LoggerFactory.getLogger(DepartmentServiceTest.class) ;

    @Autowired
    private DepartmentService departmentService ;

    @Test
    public void loadAllDepartmentsTest(){

        List<DepartmentEntity> departmentEntityList =  departmentService.loadAllDepartments() ;

        for( DepartmentEntity departmentEntity : departmentEntityList ) {
            logger.debug("deptId: {} , name : {} " ,  departmentEntity.getId() , departmentEntity.getName() );
        }

        assertThat(departmentEntityList).isNotEmpty() ;
    }

    @Test
    public void loadDepartmentEntityAndProductsTest(){

        DepartmentEntity departmentEntity = departmentService.loadDepartmentEntityAndProducts(1) ;
        for( ProductEntity productEntity : departmentEntity.getProductEntityList() ) {
            logger.debug("proId : {} , name : {} , deptId : {}  " ,  productEntity.getId() , productEntity.getName() , productEntity.getDeptId() );
        }
        assertThat(departmentEntity.getProductEntityList()).isNotEmpty() ;
    }

    @Test
    public void initDepartmentEntityAndProductsTest(){

        DepartmentEntity departmentEntity = departmentService.loadDepartmentEntityAndProducts(1) ;
        for( ProductEntity productEntity : departmentEntity.getProductEntityList() ) {
            logger.debug("proId : {} , name : {} , deptId : {}  " ,  productEntity.getId() , productEntity.getName() , productEntity.getDeptId() );
        }

        // create charts
        FlowchartsBuilder builder = new FlowchartsBuilder() ;
        Graph graph = new Graph() ;
        graph.setLayout(Graph.TB);
        graph.addNode(departmentEntity.initNode());

        logger.debug("node text : {}" , builder.build(graph) );
        assertThat(departmentEntity.getProductEntityList()).isNotEmpty() ;
        assertThat(departmentEntity.initNode().getNodeText()).isNotEmpty() ;
    }

    @Test
    public void deleteDeptNot(){

        Integer deptId = 1 ;
        Boolean isDel = departmentService.deleteDept(deptId) ;
        assertThat(isDel).isFalse() ;
    }

    @Test
    public void deleteDeptYes(){

        Integer deptId = 21 ;
        Boolean isDel = departmentService.deleteDept(deptId) ;
        assertThat(isDel).isTrue() ;
    }
}
