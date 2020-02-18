package com.test

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import grails.gorm.annotation.Entity
import org.grails.datastore.gorm.GormEntity


@Entity
@JsonIgnoreProperties(["errors", "attached"])
class Laboratory implements GormEntity<Laboratory> {

    String cuit
    String gln
    String name
    List<Medication> medications = new ArrayList<Medication>()

    static hasMany = [medications: Medication]
}
