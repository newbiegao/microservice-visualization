package org.keron.microservicevisualization.entity;

import javax.persistence.*;

@Entity
@Table(name = "T_PRODUCT")
public class ProductEntity {

    @Id
    @Column(name = "PRO_ID")
    private Integer id ;

    @Column(name = "DEPT_ID")
    private Integer deptId ;

    @Column(name = "PRO_NAME")
    private String name ;

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
}
