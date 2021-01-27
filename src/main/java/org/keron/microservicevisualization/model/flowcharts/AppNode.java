package org.keron.microservicevisualization.model.flowcharts;

public class AppNode extends Node {

    private static final String CUBE = "cube" ;
    private static final String CUBES = "cubes" ;

    public AppNode(String id ){
        super.setId( id );
        this.nodeTemplate = "([\" <p onclick=show(event,'${id}'); >fa:fa-${cube}(${count}) ${title}</p> \"])" ;
    }

    @Override
    public String processNodeTextExt(String nodeText) {
        if( super.getCount() > 1)
        {
            return nodeText.replace("${cube}" , CUBES) ;
        }
        else
        {
            return nodeText.replace("${cube}" , CUBE) ;
        }

    }
}

