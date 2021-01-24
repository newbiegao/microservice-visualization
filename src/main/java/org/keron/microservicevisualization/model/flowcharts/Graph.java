package org.keron.microservicevisualization.model.flowcharts;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Graph implements Charts {

    private static final String NODE_TEXT = "graph " ;

    public static final  String LR  = "LR" ;
    public static final  String RL  = "RL" ;
    public static final  String TB  = "TB" ;
    public static final  String BT  = "BT" ;

    private TreeMap<String , Node> nodeIndex  = new TreeMap<>() ;

    private List<Link> linkList = new ArrayList<>() ;

    private String layout ;

    public String getLayout() {
        return layout;
    }

    public void setLayout(String layout) {
        this.layout = layout;
    }

    public void addNode( Node node  ){

        if( node == null ||  node.getId() == null || node.getId().isEmpty() ) {
            return ;
        }

        if( this.nodeIndex.containsKey( node.getId() ) ) {
            return ;
        }

        this.nodeIndex.put( node.getId() , node ) ;

    }

    public List<Node> getNodeList(){
       return this.nodeIndex.values().stream().collect(Collectors.toList()) ;
    }

    public void addLink( Link link ){
        this.linkList.add( link ) ;
    }

    public List<Link> getLinks(){
        return this.linkList ;
    }

    @Override
    public String getNodeText(){

        return NODE_TEXT + layout + ";" ;

    }

}
