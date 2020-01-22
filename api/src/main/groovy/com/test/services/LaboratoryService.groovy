package com.test.services

import com.test.Laboratory
//import edu.umd.cs.findbugs.annotations.NonNull
import grails.gorm.services.Service
import groovy.transform.CompileStatic

@Service(Laboratory)
@CompileStatic
abstract class LaboratoryService {
    abstract Laboratory findByCuit(String cuit)
    abstract Iterable<Laboratory> findAll()
    abstract Laboratory findOrCreateBy(String cuit, String gln, String name)
    abstract Laboratory save(Laboratory laboratory)
    abstract Long count()
}
