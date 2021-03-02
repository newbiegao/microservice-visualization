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

    public List loadLinkList( Integer fromProId , Integer fromSysId , Integer toProId , Integer toSysId ){
        String sql = "select lk.LK_ID, s.SYS_TITLE fromTitle , lk.LK_TITLE , s1.SYS_TITLE toTitle " +
                    "from T_LINK lk " +
                    "left join T_SYSTEM s on lk.FROM_ID = s.SYS_ID " +
                    "left join T_SYSTEM s1 on lk.TO_ID = s1.SYS_ID " +
                    "where s.PRO_ID = :fromProId and s1.PRO_ID = :toProId ";
        if( fromSysId > 0 ){
            sql = sql + " and lk.FROM_ID =:fromSysId " ;
        }
        if( toSysId > 0 ){
            sql = sql + " and lk.TO_ID =:toSysId " ;
        }
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("fromProId" , fromProId) ;
        query.setParameter("toProId" , toProId) ;
        if( fromSysId > 0 ){
            query.setParameter("fromSysId" , fromSysId) ;
        }
        if( toSysId > 0 ){
            query.setParameter("toSysId" , toSysId) ;
        }
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

    public void deleteLink( Integer linkId ){
        linkRepository.deleteById(linkId);
    }


}
