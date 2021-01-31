package org.keron.microservicevisualization.model.flowcharts;

public abstract class Node implements Charts {

    private String id ;

    private String title ;

    private String description  ;

    protected String nodeTemplate ;

    private Integer count = 1 ;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

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

    public abstract String processNodeTextExt( String nodeText ) ;

    @Override
    public String getNodeText() {

        StringBuilder stringBuilder = new StringBuilder() ;
        stringBuilder.append(this.getId()) ;
        if ( this.title == null  ) { this.title = "" ; }

        // 处理节点模版信息
        String nodeText = this.nodeTemplate.replace("${title}" , this.title ).replace("${id}" , this.getId()).replace("${count}",this.count.toString()) ;
        stringBuilder.append(  processNodeTextExt(nodeText) )  ;

        stringBuilder.append("; ") ;
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

    public static Node getSubgraphInstance( String id ) { return new Subgraph(id) ; }

    public static Node getFrontAppInstance( String id ) { return new FrontAppNode(id) ; }

    public static Node getFrontH5Instance( String id ) { return new FrontH5Node(id) ; }
}
