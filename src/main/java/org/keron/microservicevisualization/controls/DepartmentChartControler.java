package org.keron.microservicevisualization.controls;

import org.keron.microservicevisualization.FlowchartsBuilder;
import org.keron.microservicevisualization.entity.DepartmentEntity;
import org.keron.microservicevisualization.model.data.ServerInfo;
import org.keron.microservicevisualization.model.flowcharts.*;
import org.keron.microservicevisualization.service.DepartmentService;
import org.keron.microservicevisualization.service.GraphService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class DepartmentChartControler {

    @Autowired
    private GraphService graphService  ;

    @Autowired
    private DepartmentService departmentService ;

    @GetMapping("/chart/dept/{deptId}/{direction}")
    public String loadDeptChart( @PathVariable Integer deptId , @PathVariable String direction ){

        if( deptId > 0 ){
            return graphService.loadDepartmentProductChart(deptId , direction) ;
        }
        else{
            return graphService.loadAllDepartmentProductChart(direction) ;
        }

    }


    @GetMapping("/data/depts")
    public List<DepartmentEntity> loadDeptList(){

        return  departmentService.loadAllDepartments() ;

    }

}
