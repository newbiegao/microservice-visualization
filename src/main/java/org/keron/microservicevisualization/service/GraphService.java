package org.keron.microservicevisualization.service;

import org.keron.microservicevisualization.FlowchartsBuilder;
import org.keron.microservicevisualization.entity.DepartmentEntity;
import org.keron.microservicevisualization.model.flowcharts.Graph;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GraphService {

    private static Logger logger = LoggerFactory.getLogger(GraphService.class);

    @Autowired
    private DepartmentService departmentService ;

    public String loadDepartmentProductChart( Integer deptId ){

        DepartmentEntity departmentEntity = departmentService.loadDepartmentEntityAndProducts(deptId) ;

        // create charts
        FlowchartsBuilder builder = new FlowchartsBuilder() ;
        Graph graph = new Graph() ;
        graph.setLayout(Graph.TB);
        graph.addNode(departmentEntity.initNode());
        String text = builder.build(graph) ;

        logger.debug("node text : {}" , text);
        return text ;

    }

}
