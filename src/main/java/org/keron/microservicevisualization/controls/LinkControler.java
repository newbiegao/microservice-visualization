package org.keron.microservicevisualization.controls;

import org.keron.microservicevisualization.entity.LinkEntity;
import org.keron.microservicevisualization.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LinkControler {

    @Autowired
    private LinkService linkService ;

    @GetMapping("/data/link/list")
    public List loadLinkList(){
        return linkService.loadLinkList() ;
    }

    @PostMapping("/data/link/save")
    public LinkEntity saveLinkEntity( Integer fromId , Integer toId , String title ){
        return linkService.saveLink(fromId , toId , title) ;
    }

    @PostMapping("/data/link/delete")
    public boolean deleteLink( Integer linkId ){
         linkService.deleteLink(linkId);
         return true ;
    }
}
