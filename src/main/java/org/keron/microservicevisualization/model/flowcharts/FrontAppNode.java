package org.keron.microservicevisualization.model.flowcharts;

public class FrontAppNode extends Node {

    public FrontAppNode( String id ){

        super.setId(id);
        this.nodeTemplate = "[\" <p onclick=show(event,'${id}'); >fa:fa:fa-apple fa:fa-android(${count}) ${title}</p> \"]" ;

    }

    @Override
    public String processNodeTextExt(String nodeText) {
        return nodeText ;
    }


}
