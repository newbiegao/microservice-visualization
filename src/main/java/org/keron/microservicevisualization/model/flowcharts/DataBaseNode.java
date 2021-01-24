package org.keron.microservicevisualization.model.flowcharts;

public class DataBaseNode extends Node {

    public DataBaseNode( String id ){

        super.setId( id );

        this.nodeTemplate = "[( ${title} )]" ;

    }

}
