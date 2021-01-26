package org.keron.microservicevisualization.model.flowcharts;

public class OuterNode extends Node {

    public OuterNode(String id ){

        super.setId( id );

        this.nodeTemplate = "[[\" <p onclick=show(event,'${id}'); >fa:fa-cubes ${title}</p> \"]]" ;
    }

}

