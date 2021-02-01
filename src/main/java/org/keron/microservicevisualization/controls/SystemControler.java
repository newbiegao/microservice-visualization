package org.keron.microservicevisualization.controls;

import org.keron.microservicevisualization.entity.DepartmentEntity;
import org.keron.microservicevisualization.entity.SystemEntity;
import org.keron.microservicevisualization.service.DepartmentService;
import org.keron.microservicevisualization.service.GraphService;
import org.keron.microservicevisualization.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SystemControler {

    @Autowired
    private SystemService systemService  ;

    @GetMapping("/chart/system/{sysId}")
    public SystemEntity loadSystemInfo(@PathVariable String sysId  ){
        Integer id = Integer.valueOf( sysId.replace("SYS","") );
       return systemService.loadSystemEntity(id) ;
    }

}
