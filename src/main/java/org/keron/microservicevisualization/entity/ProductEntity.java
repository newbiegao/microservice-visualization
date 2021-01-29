package org.keron.microservicevisualization.entity;

import org.keron.microservicevisualization.model.flowcharts.Node;
import org.keron.microservicevisualization.model.flowcharts.Subgraph;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "T_PRODUCT")
public class ProductEntity implements NodeProcessInterface {

    private static final String NODEID_PREFIX = "PRO" ;

    @Id
    @Column(name = "PRO_ID")
    private Integer id ;

    @Column(name = "DEPT_ID")
    private Integer deptId ;

    @Column(name = "PRO_NAME")
    private String name ;

    @Transient
    private List<SystemEntity> systemEntityList = new ArrayList<>() ;

    @Transient
    private Subgraph node ;

    public List<SystemEntity> getSystemEntityList() {
        return systemEntityList;
    }

    public void setSystemEntityList(List<SystemEntity> systemEntityList) {
        this.systemEntityList = systemEntityList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Node initNode() {

        // create Node instance
        this.node = (Subgraph)Node.getSubgraphInstance(String.valueOf(this.id)) ;

        // set node property
        this.node.setId(NODEID_PREFIX+this.id);
        this.node.setTitle(this.name);

        // add child Node
        for( SystemEntity systemEntity : systemEntityList ){
            this.node.addChild(systemEntity.initNode());
        }

        return this.node ;
    }
}
