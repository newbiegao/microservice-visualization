package org.keron.microservicevisualization;

import org.junit.jupiter.api.Test;
import org.keron.microservicevisualization.entity.SystemEntity;
import org.keron.microservicevisualization.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class SystemServiceTest {

    @Autowired
    private SystemService systemService ;

    @Test
    public void loadSystemEntityTest(){
        Integer sysId = 1 ;
        SystemEntity systemEntity =  systemService.loadSystemEntity(sysId) ;
        assertThat(systemEntity).isNotNull() ;
    }

}
