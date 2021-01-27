package org.keron.microservicevisualization.model.flowcharts;

public class Subgraph extends Node  {

    @Override
    public String processNodeTextExt(String nodeText) {
        return nodeText ;
    }

    @Override
    public String getNodeText() {
        return null;
    }
}
