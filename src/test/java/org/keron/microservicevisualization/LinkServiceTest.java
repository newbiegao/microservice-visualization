package org.keron.microservicevisualization;


import org.junit.jupiter.api.Test;
import org.keron.microservicevisualization.entity.LinkEntity;
import org.keron.microservicevisualization.service.LinkService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class LinkServiceTest {

    private static Logger logger = LoggerFactory.getLogger(LinkServiceTest.class) ;

    @Autowired
    private LinkService linkService ;

    @Test
    public void loadLinksTest(){

        List<Integer> nodeIds = new ArrayList<>() ;
        nodeIds.add(1) ;
        nodeIds.add(2) ;
        nodeIds.add(3) ;

        List<LinkEntity> linkEntityList = linkService.loadLinks(nodeIds ) ;

        for( LinkEntity linkEntity : linkEntityList ){
            logger.debug("link : " + linkEntity.getTitle());
        }

        assertThat(linkEntityList).isNotEmpty()  ;
    }
}
