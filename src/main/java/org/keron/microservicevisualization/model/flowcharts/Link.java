package org.keron.microservicevisualization.model.flowcharts;

public class Link implements Charts {

    public Link( String  formNodeId , String  toNodeId){
        this.formNodeId = formNodeId ;
        this.toNodeId = toNodeId ;
    }

    protected String linkTemplate = " --> " ;

    protected String linkTitleTemplate = " -- ${title} --> " ;

    private String title ;

    private String formNodeId ;

    private String toNodeId ;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    @Override
    public String getNodeText() {

        StringBuilder stringBuilder = new StringBuilder() ;
        stringBuilder.append(this.formNodeId) ;
        if( this.title == null || this.title.isEmpty() )
        {
            stringBuilder.append( this.linkTemplate ) ;
        }
        else
        {
            stringBuilder.append( this.linkTitleTemplate.replace("${title}" , this.title) );
        }
        stringBuilder.append(this.toNodeId) ;
        stringBuilder.append(" ; ") ;

        return stringBuilder.toString() ;
    }
}
