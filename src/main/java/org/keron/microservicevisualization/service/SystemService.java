package org.keron.microservicevisualization.service;

import org.keron.microservicevisualization.entity.SystemEntity;
import org.keron.microservicevisualization.repository.SystemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class SystemService {

    @Autowired
    private SystemRepository systemRepository ;

    public SystemEntity loadSystemEntity( Integer sysId ){
        return systemRepository.loadSystemEntity(sysId) ;
    }

    public List<SystemEntity> loadSystemListByProId (Integer proId ){
        return systemRepository.loadSystemEntityListByProId(proId) ;
    }

    /**
     *
     * @param proId
     * @param sysId
     * @param sysName
     * @param sysTitle
     * @param sysType
     * @param sysCount
     * @return
     */
    public SystemEntity saveSystemEntity( Integer proId , Integer sysId , String sysName , String sysTitle , String sysType , Integer sysCount ){
        SystemEntity systemEntity = systemRepository.loadSystemEntity(sysId) ;
        if( systemEntity == null ){
            systemEntity = new SystemEntity() ;
            systemEntity.setId(sysId);
        }
        systemEntity.setName(sysName);
        systemEntity.setProId(proId);
        systemEntity.setTitle(sysTitle);
        systemEntity.setType(sysType);
        systemEntity.setCount(sysCount);
        systemRepository.saveAndFlush(systemEntity) ;
        return systemEntity ;
    }

    public boolean deleteSystem( Integer sysId ){
        // TODO: delete node link entity

        systemRepository.deleteById(sysId);
        return true ;
    }
}
