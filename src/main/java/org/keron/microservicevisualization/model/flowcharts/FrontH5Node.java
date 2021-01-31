package org.keron.microservicevisualization.model.flowcharts;

public class FrontH5Node extends Node {

    public FrontH5Node(String id){

        super.setId(id);
        this.nodeTemplate = "[\" <p onclick=show(event,'${id}'); >fa:fa-chrome (${count}) ${title}</p> \"]" ;

    }

    @Override
    public String processNodeTextExt(String nodeText) {
        return nodeText ;
    }

}
