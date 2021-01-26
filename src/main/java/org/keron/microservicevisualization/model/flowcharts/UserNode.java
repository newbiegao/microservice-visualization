package org.keron.microservicevisualization.model.flowcharts;

public class UserNode extends Node {

    public UserNode(String id ){

        super.setId( id );

        this.nodeTemplate = "((\" <p onclick=show(event,'${id}'); >fa:fa-user-circle-o ${title}</p> \"))" ;
    }

}

