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
        if( this.title == null  ) this.title = "" ;
        stringBuilder.append(this.nodeTemplate.replace("${title}" , this.title ))  ;
        stringBuilder.append(";") ;
        return stringBuilder.toString() ;
    }
}
