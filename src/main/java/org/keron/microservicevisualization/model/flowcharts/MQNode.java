package org.keron.microservicevisualization.model.flowcharts;

public class MQNode extends Node {

    public MQNode(String id ){

        super.setId( id );

        this.nodeTemplate = "{{\" <p onclick=show(event,'${id}'); >fa:fa-envelope(${count}) ${title}</p> \"}}" ;
    }

    @Override
    public String processNodeTextExt(String nodeText) {
        return nodeText ;
    }
}

