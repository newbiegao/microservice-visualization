package org.keron.microservicevisualization.model.flowcharts;

public abstract class Node implements Charts {

    private String id ;

    private String title ;

    private String description  ;

    protected String nodeTemplate ;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String getNodeText() {

        StringBuilder stringBuilder = new StringBuilder() ;
        stringBuilder.append(this.getId()) ;
        if ( this.title == null  ) { this.title = "" ; }
        stringBuilder.append(this.nodeTemplate.replace("${title}" , this.title ).replace("${id}" , this.getId()))  ;
        stringBuilder.append(";") ;
        return stringBuilder.toString() ;
    }

    public static Node getAppNodeInstance( String id ){
        return new AppNode(id) ;
    }

    public static Node getDataBaseInstance( String id ){
        return new DataBaseNode(id) ;
    }

    public static Node getNginxNodeInstance( String id ){
        return new NginxNode(id) ;
    }

    public static Node getRedisNodeInstance( String id ){
        return new RedisNode(id) ;
    }

    public static Node getUserNodeInstance( String id ){
        return new UserNode(id) ;
    }

    public static Node getMQNodeInstance( String id ){
        return new MQNode(id);
    }

    public static Node getOuterNodeInstance( String id ) { return new OuterNode(id) ; }

}
