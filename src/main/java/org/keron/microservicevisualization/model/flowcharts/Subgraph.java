package org.keron.microservicevisualization.model.flowcharts;

import java.util.ArrayList;
import java.util.List;

public class Subgraph extends Node  {

    private List<Node> childNodes = new ArrayList<>() ;

    public Subgraph( String id ){

        super.setId(id);

        this.nodeTemplate = "subgraph ${id} [${title}]; " ;

    }

    public void addChild( Node child ){
        this.childNodes.add(child) ;
    }

    @Override
    public String getNodeText(){

        StringBuilder stringBuilder = new StringBuilder() ;
        stringBuilder.append( this.nodeTemplate.replace("${id}" , this.getId()).replace("${title}", this.getTitle() ) ) ;
        // 构造子节点
        for( Node node : this.childNodes ){
            stringBuilder.append( node.getNodeText() ) ;
        }
        stringBuilder.append(" end ") ;
        return  stringBuilder.toString() ;
    }

    @Override
    public String processNodeTextExt(String nodeText) {
        return nodeText ;
    }


}
