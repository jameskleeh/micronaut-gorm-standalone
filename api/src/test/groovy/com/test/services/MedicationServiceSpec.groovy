package com.test.services

import com.test.Laboratory
import com.test.Medication
import io.micronaut.test.annotation.MicronautTest
import spock.lang.Ignore
import spock.lang.Shared
import spock.lang.Specification

import javax.inject.Inject

@MicronautTest
@Ignore
class MedicationServiceSpec extends Specification {

    @Shared @Inject
    MedicationService medicationService

    @Shared @Inject
    LaboratoryService laboratoryService


    void "add a medication to the laboraty list of medications"() {
        given:
        Laboratory laboratory = laboratoryService.findOrCreateBy("123", "55", "Name")

        when: "a medication is saved"
        Medication medication = new Medication()
        medication.certificateNumber = 12345
        medication.laboratory = laboratory
        medication.commercialName = "commercialName"

        medicationService.save(medication)

        then:
        medication.id != null
        medicationService.findById(medication.id).isPresent()
        medicationService.findById(medication.id).get().certificateNumber == 12345
        medicationService.findById(medication.id).get().commercialName == "commercialName"
        medicationService.count() == 1
    }

}
