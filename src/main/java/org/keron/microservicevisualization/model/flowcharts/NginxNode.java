package org.keron.microservicevisualization.model.flowcharts;

public class NginxNode extends Node {

    public NginxNode( String id ){
        super.setId(id);
        this.nodeTemplate = "{\" <p onclick=show(event,'${id}'); >fa:fa-sitemap ${title}</p> \"}" ;
    }

}
