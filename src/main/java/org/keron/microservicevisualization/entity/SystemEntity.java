package org.keron.microservicevisualization.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "T_SYSTEM")
public class SystemEntity {

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
}
