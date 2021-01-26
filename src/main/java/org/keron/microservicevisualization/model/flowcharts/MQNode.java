package org.keron.microservicevisualization.model.flowcharts;

public class MQNode extends Node {

    public MQNode(String id ){

        super.setId( id );

        this.nodeTemplate = "{{\" <p>fa:fa-envelope ${title}</p> \"}}" ;
    }

}

