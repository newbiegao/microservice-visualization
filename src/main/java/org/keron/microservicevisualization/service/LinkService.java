package org.keron.microservicevisualization.service;

import org.keron.microservicevisualization.repository.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LinkService {

    @Autowired
    private LinkRepository linkRepository ;


}
