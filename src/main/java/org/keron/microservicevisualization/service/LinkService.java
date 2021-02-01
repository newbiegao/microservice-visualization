package org.keron.microservicevisualization.service;

import org.keron.microservicevisualization.entity.LinkEntity;
import org.keron.microservicevisualization.repository.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LinkService {

    @Autowired
    private LinkRepository linkRepository ;

    public List<LinkEntity> loadLinks(List<Integer> nodeIds ){

        List<LinkEntity> fromList = linkRepository.loadFromLinks(nodeIds) ;

        // find toIds in fromIds
        List<LinkEntity> newFromList = new ArrayList<>() ;
        for( LinkEntity from : fromList ){
           if( nodeIds.contains( from.getToId() ) ) {
               newFromList.add( from ) ;
           }
        }

        return  newFromList ;

    }

}
