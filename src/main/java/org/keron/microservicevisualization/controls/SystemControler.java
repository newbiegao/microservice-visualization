package org.keron.microservicevisualization.controls;

import org.keron.microservicevisualization.entity.DepartmentEntity;
import org.keron.microservicevisualization.entity.SystemEntity;
import org.keron.microservicevisualization.service.DepartmentService;
import org.keron.microservicevisualization.service.GraphService;
import org.keron.microservicevisualization.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

    @GetMapping("/data/systems/{proId}")
    public List<SystemEntity> loadSystemListByProId( @PathVariable Integer proId ){
        return systemService.loadSystemListByProId(proId) ;
    }

    @GetMapping("/data/system/{sysId}")
    public SystemEntity loadSystemInfoById(@PathVariable Integer sysId ){
        return systemService.loadSystemEntity(sysId) ;
    }

    @PostMapping("/data/system/delete")
    public Boolean deleteSystem( Integer sysId ){
        return systemService.deleteSystem(sysId) ;
    }

    @PostMapping("/data/system/save")
    public SystemEntity saveSystem( Integer proId , Integer sysId , String sysName , String sysTitle , String sysType , Integer sysCount  ){
        return systemService.saveSystemEntity( proId , sysId , sysName , sysTitle , sysType , sysCount ) ;
    }

}
