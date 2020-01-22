package com.test.services

import com.test.Medication
import grails.gorm.services.Service

@Service(Medication)
interface MedicationService {
    Medication findByCertificateNumber(String certificateNumber)
    Long count()
}
