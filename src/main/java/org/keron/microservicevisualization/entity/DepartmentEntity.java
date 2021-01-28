package org.keron.microservicevisualization.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "T_DEPT")
public class DepartmentEntity {

    @Id
    @Column(name = "DEPT_ID")
    private Integer id ;

    @Column(name = "DEPT_NAME")
    private String name  ;

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
}
