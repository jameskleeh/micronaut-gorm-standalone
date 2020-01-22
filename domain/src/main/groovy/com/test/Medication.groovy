package com.test

import grails.gorm.annotation.Entity
import org.grails.datastore.gorm.GormEntity

import javax.validation.constraints.NotNull

@Entity
class Medication implements GormEntity<Medication> {
    @NotNull
    Long certificateNumber
    @NotNull
    Laboratory laboratory
    @NotNull
    String commercialName

    static belongsTo = [laboratory: Laboratory]
}
