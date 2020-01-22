package com.test

import grails.gorm.annotation.Entity
import org.grails.datastore.gorm.GormEntity


@Entity
class Laboratory implements GormEntity<Laboratory> {
    String cuit
    String gln
    String name
    List<Medication> medications = new ArrayList<Medication>()

    static hasMany = [medications: Medication]
}
