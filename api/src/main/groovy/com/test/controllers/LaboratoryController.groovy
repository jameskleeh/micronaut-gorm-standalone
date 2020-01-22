package com.test.controllers

import com.test.Laboratory
import com.test.services.LaboratoryService
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Consumes
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post

import javax.inject.Inject


@Controller("/laboratory")
class LaboratoryController {
    @Inject LaboratoryService laboratoryService

    @Get("/")
    List<Laboratory> index(Integer page) {
        return laboratoryService.findAll()
    }

    @Get("/list")
    List<Laboratory> list(Integer page) {
        return laboratoryService.findAll()
    }

    @Post("/")
    @Consumes(MediaType.APPLICATION_JSON)
    Laboratory save(@Body Laboratory laboratory) {
        return laboratoryService.save(laboratory)
    }
}
