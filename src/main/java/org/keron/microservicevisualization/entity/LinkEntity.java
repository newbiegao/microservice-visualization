package org.keron.microservicevisualization.entity;

import org.keron.microservicevisualization.model.flowcharts.Link;
import org.keron.microservicevisualization.model.flowcharts.Node;

import javax.persistence.*;

@Entity
@Table(name = "T_LINK")
public class LinkEntity implements NodeProcessInterface {

    private static final String NODE_PREFIX = "SYS" ;

    @Id
    @Column(name = "LK_ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id ;

    @Column(name = "FROM_ID")
    private Integer fromId ;

    @Column(name = "TO_ID")
    private Integer toId ;

    @Column(name = "LK_TITLE")
    private String title ;

    @Transient
    private Link link ;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFromId() {
        return fromId;
    }

    public void setFromId(Integer fromId) {
        this.fromId = fromId;
    }

    public Integer getToId() {
        return toId;
    }

    public void setToId(Integer toId) {
        this.toId = toId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public Node initNode() {

        String fromId = NODE_PREFIX + this.fromId ;
        String toId = NODE_PREFIX + this.toId ;

        this.link = new Link( fromId  , toId) ;
        this.link.setTitle(this.title);
        return this.link ;
    }
}
