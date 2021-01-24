package org.keron.microservicevisualization.model.flowcharts;

public class AppNode extends Node {


    public AppNode( String id ){

        super.setId( id );

        this.nodeTemplate = "[ ${title} ]" ;
    }


}

