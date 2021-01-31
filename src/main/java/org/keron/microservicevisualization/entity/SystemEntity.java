package org.keron.microservicevisualization.entity;

import org.keron.microservicevisualization.model.flowcharts.Node;

import javax.persistence.*;

@Entity
@Table(name = "T_SYSTEM")
public class SystemEntity implements NodeProcessInterface {

    private static final String NODE_PREFIX = "SYS" ;

    @Id
    @Column(name = "SYS_ID")
    private Integer id ;

    @Column(name = "PRO_ID")
    private Integer proId ;

    @Column(name = "SYS_COUNT")
    private Integer count  ;

    @Column(name = "SYS_NAME")
    private String  name   ;

    @Column(name = "SYS_TITLE")
    private String  title   ;

    @Column(name = "SYS_TYPE")
    private String  type   ;

    @Transient
    private Node node ;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProId() {
        return proId;
    }

    public void setProId(Integer proId) {
        this.proId = proId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public Node initNode() {

        if( this.getType().equalsIgnoreCase("database") ){
            this.node = Node.getDataBaseInstance(String.valueOf(this.getId())) ;
        }
        if( this.getType().equalsIgnoreCase("app") ){
            this.node = Node.getAppNodeInstance(String.valueOf(this.getId())) ;
        }
        if( this.getType().equalsIgnoreCase("nginx") ){
            this.node = Node.getNginxNodeInstance(String.valueOf(this.getId())) ;
        }
        if( this.getType().equalsIgnoreCase("mq") ){
            this.node = Node.getMQNodeInstance(String.valueOf(this.getId())) ;
        }
        if( this.getType().equalsIgnoreCase("outer") ){
            this.node = Node.getOuterNodeInstance(String.valueOf(this.getId())) ;
        }
        if( this.getType().equalsIgnoreCase("redis") ){
            this.node = Node.getRedisNodeInstance(String.valueOf(this.getId())) ;
        }
        if( this.getType().equalsIgnoreCase("user") ){
            this.node = Node.getUserNodeInstance(String.valueOf(this.getId())) ;
        }
        if( this.getType().equalsIgnoreCase("h5") ){
            this.node = Node.getFrontH5Instance(String.valueOf(this.getId())) ;
        }
        if( this.getType().equalsIgnoreCase("app") ){
            this.node = Node.getFrontAppInstance(String.valueOf(this.getId())) ;
        }

        // set node property
        this.node.setId(NODE_PREFIX+this.id);
        this.node.setTitle(this.name);
        this.node.setCount(this.count);

        return this.node ;
    }
}
