package org.keron.microservicevisualization.controls;

import org.keron.microservicevisualization.FlowchartsBuilder;
import org.keron.microservicevisualization.model.data.ServerInfo;
import org.keron.microservicevisualization.model.flowcharts.*;
import org.keron.microservicevisualization.service.DepartmentService;
import org.keron.microservicevisualization.service.GraphService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class DepartmentChartControler {

    @Autowired
    private GraphService graphService  ;

    @GetMapping("/chart/dept/{deptId}/{direction}")
    public String loadChartText( @PathVariable Integer deptId , @PathVariable String direction ){

        return graphService.loadDepartmentProductChart(deptId) ;
    }

}
