package org.keron.microservicevisualization;

import org.keron.microservicevisualization.model.flowcharts.Graph;
import org.keron.microservicevisualization.model.flowcharts.Link;
import org.keron.microservicevisualization.model.flowcharts.Node;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class FlowchartsBuilder {

    private static Logger logger = LoggerFactory.getLogger(FlowchartsBuilder.class);

    public String build( Graph graph ){

        StringBuilder stringBuilder = new StringBuilder() ;
        stringBuilder.append(graph.getNodeText() ) ;

        // build nodes
        for(Node node : graph.getNodeList()){
            stringBuilder.append( node.getNodeText() ) ;
        }

        // build links
        for( Link link : graph.getLinks() ){

            stringBuilder.append( link.getNodeText() ) ;

        }


        String text = stringBuilder.toString() ;

        logger.debug( "text : {}" , text );
        return text  ;

    }

}
