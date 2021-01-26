package org.keron.microservicevisualization.model.flowcharts;

public class RedisNode extends Node {

    public RedisNode( String id ){
        super.setId(id);
        this.nodeTemplate = "[(\" <p onclick=show(event,'${id}'); >fa:fa-cogs ${title}</p> \")]" ;
    }

}
