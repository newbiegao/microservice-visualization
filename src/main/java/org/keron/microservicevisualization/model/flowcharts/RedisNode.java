package org.keron.microservicevisualization.model.flowcharts;

public class RedisNode extends Node {

    public RedisNode( String id ){
        super.setId(id);
        this.nodeTemplate = "[(\" <p onclick=show(event,'${id}'); >fa:fa-cogs(${count}) ${title}</p> \")]" ;
    }

    @Override
    public String processNodeTextExt(String nodeText) {
        return nodeText ;
    }
}
