package org.keron.microservicevisualization.service;

import org.keron.microservicevisualization.FlowchartsBuilder;
import org.keron.microservicevisualization.entity.DepartmentEntity;
import org.keron.microservicevisualization.entity.LinkEntity;
import org.keron.microservicevisualization.entity.ProductEntity;
import org.keron.microservicevisualization.entity.SystemEntity;
import org.keron.microservicevisualization.model.flowcharts.Graph;
import org.keron.microservicevisualization.model.flowcharts.Link;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GraphService {

    private static Logger logger = LoggerFactory.getLogger(GraphService.class);

    @Autowired
    private DepartmentService departmentService ;

    @Autowired
    private ProductService productService ;

    @Autowired
    private LinkService linkService ;

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

        // load links
        List<LinkEntity> linkEntityList = loadLinks(productEntity.getSystemEntityList()) ;

        // build node
        FlowchartsBuilder builder = new FlowchartsBuilder() ;
        Graph graph = new Graph() ;
        graph.setLayout(direction);

        for(SystemEntity systemEntity : productEntity.getSystemEntityList()){
            graph.addNode(systemEntity.initNode());
        }
        // add node link
        for( LinkEntity linkEntity : linkEntityList ){
            graph.addLink( (Link)linkEntity.initNode() );
        }

        return builder.build(graph) ;
    }

    private List<LinkEntity> loadLinks( List<SystemEntity> systemEntityList ){

        List<Integer> nodeIds = new ArrayList<>() ;

        for( SystemEntity systemEntity : systemEntityList ){
            nodeIds.add(systemEntity.getId()) ;
        }

        return this.linkService.loadLinkEntitys(nodeIds) ;

    }

}
