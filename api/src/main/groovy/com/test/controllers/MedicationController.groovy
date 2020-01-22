package com.test.controllers

import com.test.Medication
import com.test.services.MedicationService
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post

import javax.inject.Inject

@Controller("/medication")
class MedicationController {
    @Inject MedicationService medicationService

    @Get("/")
    List<Medication> index(Integer page) {
        return medicationService.findAll()
    }

    @Get("/list")
    List<Medication> list(Integer page) {
        return medicationService.findAll()
    }

    @Post("/")
    Medication save(Medication medication) {
        return medicationService.save(medication)
    }

}
