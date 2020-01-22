package com.test.services

import com.test.Medication
import io.micronaut.test.annotation.MicronautTest
import spock.lang.Ignore
import spock.lang.Shared
import spock.lang.Specification

import javax.inject.Inject

@MicronautTest
@Ignore
class LaboratoryServiceSpec extends Specification {

    @Shared @Inject
    LaboratoryService laboratoryService

    def setupSpec() {
    }

    void "save a laboratory"() {
        when: "a laboratory is saved"
        def laboratory = laboratoryService.findOrCreateBy("123", "55", "Name")

        then:
        laboratory.id != null
        laboratoryService.findById(laboratory.id).isPresent()
        laboratoryService.findById(laboratory.id).get().cuit == "123"
        laboratoryService.findById(laboratory.id).get().gln == "55"
        laboratoryService.findById(laboratory.id).get().name == "Name"
        laboratoryService.count() == 1
    }

    void "laboratories with the same cuit are not allowed, same instance is returned"() {
        given: "a laboratory is saved"
        def laboratory1 = laboratoryService.findOrCreateBy("123", "55", "Name")

        when: "another laboratory with the same name is created"
        def laboratory2 = laboratoryService.findOrCreateBy("123", "55", "Name")

        then:
        laboratory1.id != null
        laboratory1.id == laboratory2.id
        laboratory1 == laboratory2
        laboratoryService.count() == 1
    }

    void "create a laboratory with medications on it"() {
        given: "a laboratory"
        def laboratory = laboratoryService.findOrCreateBy("123", "55", "Name")

        and: "a new medication is created"

        Medication medication = new Medication()
        medication.certificateNumber = 12345
        medication.laboratory = laboratory
        medication.commercialName = "commercialName"

        when: "the medication is added to its collection"
        laboratory.addMedication(medication)
        and: "the laboratory is saved"
        laboratoryService.save(laboratory)

        then: "the medication must have an id"
        laboratory.medications.first().id != null
    }
}
