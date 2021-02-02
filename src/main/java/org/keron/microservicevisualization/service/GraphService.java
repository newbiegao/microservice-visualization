package org.keron.microservicevisualization.service;

import org.keron.microservicevisualization.FlowchartsBuilder;
import org.keron.microservicevisualization.entity.DepartmentEntity;
import org.keron.microservicevisualization.entity.ProductEntity;
import org.keron.microservicevisualization.entity.SystemEntity;
import org.keron.microservicevisualization.model.flowcharts.Graph;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GraphService {

    private static Logger logger = LoggerFactory.getLogger(GraphService.class);

    @Autowired
    private DepartmentService departmentService ;

    @Autowired
    private ProductService productService ;

    /**
     *
     * @param deptId
     * @return
     */
    public String loadDepartmentProductChart( Integer deptId , String direction ){

        DepartmentEntity departmentEntity = departmentService.loadDepartmentEntityAndProducts(deptId) ;

        // create charts
        FlowchartsBuilder builder = new FlowchartsBuilder() ;
        Graph graph = new Graph() ;
        graph.setLayout(direction);
        graph.addNode(departmentEntity.initNode());
        String text = builder.build(graph) ;

        logger.debug("node text : {}" , text);
        return text ;

    }

    /**
     *
     * @return
     */
    public String loadAllDepartmentProductChart( String direction ){

        List<DepartmentEntity> departmentEntityList = departmentService.loadAllDepartmentEntityAndProducts() ;

        FlowchartsBuilder builder = new FlowchartsBuilder() ;
        Graph graph = new Graph() ;
        graph.setLayout(direction);

        for( DepartmentEntity departmentEntity : departmentEntityList ){
            graph.addNode(departmentEntity.initNode());
        }
        return builder.build(graph) ;
    }

    /**
     *
     * @param proId
     * @param direction
     * @return
     */
    public String loadProductAndSystemChart( Integer proId , String direction ){

        ProductEntity productEntity =  productService.loadProductEntityAndSystemEntity(proId) ;

        FlowchartsBuilder builder = new FlowchartsBuilder() ;
        Graph graph = new Graph() ;
        graph.setLayout(direction);

        for(SystemEntity systemEntity : productEntity.getSystemEntityList()){
            graph.addNode(systemEntity.initNode());
        }
        return builder.build(graph) ;
    }

}
