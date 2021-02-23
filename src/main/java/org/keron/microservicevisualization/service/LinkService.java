package org.keron.microservicevisualization.service;

import org.keron.microservicevisualization.entity.LinkEntity;
import org.keron.microservicevisualization.repository.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LinkService {

    @Autowired
    private LinkRepository linkRepository ;

    @Autowired
    private EntityManager entityManager ;

    /**
     *
     * @param nodeIds
     * @return
     */
    public List<LinkEntity> loadLinkEntitys(List<Integer> nodeIds ){

        List<LinkEntity> fromList = new ArrayList<>() ;
        if( nodeIds.isEmpty() ) { return fromList ; }
        fromList = linkRepository.loadFromLinks(nodeIds) ;

        // find toIds in fromIds
        List<LinkEntity> newFromList = new ArrayList<>() ;
        for( LinkEntity from : fromList ){
           if( nodeIds.contains( from.getToId() ) ) {
               newFromList.add( from ) ;
           }
        }
        return  newFromList ;
    }

    public List loadLinksByFromId( Integer fromSysId ){
        String sql = " select * from T_LINK where FROM_ID = :fromSysId " ;
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("fromSysId" , fromSysId) ;
        return query.getResultList() ;
    }

    public LinkEntity saveLink( Integer fromSysId , Integer toSysId , String title ){
        // find LinkEntity
        LinkEntity linkEntity = linkRepository.loadLinkByFromToId(fromSysId , toSysId) ;
        if( linkEntity == null  ){
            linkEntity = new LinkEntity() ;
        }
        linkEntity.setFromId(fromSysId);
        linkEntity.setToId(toSysId);
        linkEntity.setTitle(title);
        return linkRepository.saveAndFlush(linkEntity) ;
    }

}
