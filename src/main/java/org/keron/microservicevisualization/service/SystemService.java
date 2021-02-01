package org.keron.microservicevisualization.service;

import org.keron.microservicevisualization.entity.SystemEntity;
import org.keron.microservicevisualization.repository.SystemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SystemService {

    @Autowired
    private SystemRepository systemRepository ;

    public SystemEntity loadSystemEntity( Integer sysId ){
        return systemRepository.loadSystemEntity(sysId) ;
    }

}
