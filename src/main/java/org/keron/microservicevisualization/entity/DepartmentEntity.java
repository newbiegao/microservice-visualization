package org.keron.microservicevisualization.entity;

import org.keron.microservicevisualization.model.flowcharts.Node;
import org.keron.microservicevisualization.model.flowcharts.Subgraph;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "T_DEPT")
public class DepartmentEntity implements NodeProcessInterface {

    private static final String NODEID_PREFIX = "DEPT" ;

    @Id
    @Column(name = "DEPT_ID")
    private Integer id ;

    @Column(name = "DEPT_NAME")
    private String name  ;

    @Transient
    private Subgraph node ;

    @Transient
    private List<ProductEntity> productEntityList = new ArrayList<>() ;

    public List<ProductEntity> getProductEntityList() {
        return productEntityList;
    }

    public void setProductEntityList(List<ProductEntity> productEntityList) {
        this.productEntityList = productEntityList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        this.node = (Subgraph) Node.getSubgraphInstance(String.valueOf(this.id)) ;

        // set node property
        this.node.setId(NODEID_PREFIX+this.id);
        this.node.setTitle(this.name);

        // add child Node
        for( ProductEntity productEntity : productEntityList ){
            this.node.addChild(productEntity.initNode());
        }

        return this.node ;
    }
}
