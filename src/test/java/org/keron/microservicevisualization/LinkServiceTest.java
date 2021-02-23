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
        nodeIds.add(69) ;
        nodeIds.add(70) ;
        nodeIds.add(71) ;
        nodeIds.add(72) ;
        nodeIds.add(73) ;

        List<LinkEntity> linkEntityList = linkService.loadLinkEntitys(nodeIds ) ;

        for( LinkEntity linkEntity : linkEntityList ){
            logger.debug("link : " + linkEntity.getTitle());
        }

        assertThat(linkEntityList).isNotEmpty()  ;
    }

    @Test
    public void loadLinksByFromIdTest(){

        Integer fromSysId = 69 ;
        List list = linkService.loadLinksByFromId(fromSysId) ;
        assertThat(list).isNotEmpty();
    }

    @Test
    public void saveLinkTest(){
        Integer fromSysId = 69 ;
        Integer toSysId = 100 ;
        String tilte = fromSysId + "---" + toSysId ;
        LinkEntity linkEntity = linkService.saveLink(fromSysId , toSysId,tilte) ;
        assertThat(linkEntity).isNotNull() ;
    }
}
