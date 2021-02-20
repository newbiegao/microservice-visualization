package org.keron.microservicevisualization.controls;

import org.keron.microservicevisualization.FlowchartsBuilder;
import org.keron.microservicevisualization.entity.DepartmentEntity;
import org.keron.microservicevisualization.model.data.ServerInfo;
import org.keron.microservicevisualization.model.flowcharts.*;
import org.keron.microservicevisualization.service.DepartmentService;
import org.keron.microservicevisualization.service.GraphService;
import org.keron.microservicevisualization.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class DepartmentChartControler {

    @Autowired
    private GraphService graphService  ;

    @Autowired
    private DepartmentService departmentService ;

    @Autowired
    private ProductService productService ;

    @PostMapping("/chart/dept")
    public String loadDeptChart(@RequestParam("deptId") Integer deptId , @RequestParam("proId") Integer proId , @RequestParam("direction") String direction ){

        if( deptId > 0 ){
            if( proId > 0 ){
                return graphService.loadProductAndSystemChart(proId , direction) ;
            }
            else{
                return graphService.loadDepartmentProductChart(deptId , direction) ;
            }

        }
        else{
            return graphService.loadAllDepartmentProductChart(direction) ;
        }

    }

    @GetMapping("/data/depts")
    public List<DepartmentEntity> loadDeptList(){
        return  departmentService.loadAllDepartments() ;
    }

    @PostMapping("/data/dept/save")
    public DepartmentEntity saveDept( Integer deptId , String deptName ){

        DepartmentEntity departmentEntity = departmentService.saveDept(deptId , deptName);
        return departmentEntity ;
    }


    @PostMapping("/data/dept/delete")
    public Boolean deleteDept(Integer deptId){
        return departmentService.deleteDept(deptId) ;
    }

    @GetMapping("/data/dept/{deptId}")
    public DepartmentEntity loadDepartmentEntity(@PathVariable("deptId") Integer deptId ){
        return departmentService.loadDepartment(deptId) ;
    }

}
