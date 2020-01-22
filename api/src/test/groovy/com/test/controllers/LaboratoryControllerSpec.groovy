package com.test.controllers

import com.test.Laboratory
import io.micronaut.http.HttpMethod
import io.micronaut.http.HttpRequest
import io.micronaut.http.MediaType
import io.micronaut.http.client.annotation.Client
import io.micronaut.runtime.server.EmbeddedServer
import io.micronaut.test.annotation.MicronautTest
import io.micronaut.http.client.RxHttpClient
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import spock.lang.AutoCleanup
import spock.lang.Ignore
import spock.lang.Specification
import spock.lang.Shared

import javax.inject.Inject
import javax.transaction.Transactional

@MicronautTest
@Transactional
@Ignore
class LaboratoryControllerSpec extends Specification {

    @Shared @Inject
    EmbeddedServer embeddedServer

    @Shared @AutoCleanup @Inject @Client("/")
    RxHttpClient client

    void "test post a new laboratory"() {
        given:
        Laboratory laboratory = new Laboratory()
        laboratory.cuit = "123"
        laboratory.name = "Some name"
        laboratory.gln = "x"
        HttpRequest request = HttpRequest
                .create(HttpMethod.POST, "/laboratory")
                .body(laboratory)
                .contentType(MediaType.APPLICATION_JSON)
        HttpResponse response = client.toBlocking().exchange(request)

        expect:
        response.status == HttpStatus.OK
    }

    void "test post a new laboratory - 2"() {
        given:
        Laboratory laboratory = new Laboratory()
        laboratory.cuit = "123"
        laboratory.name = "Some name"
        laboratory.gln = "x"
        HttpRequest request = HttpRequest
                .create(HttpMethod.POST, "/laboratory")
                .body(laboratory)
                .contentType(MediaType.APPLICATION_JSON)
        Laboratory createdLaboratory = client.toBlocking().retrieve(request, Laboratory)

        expect:
        createdLaboratory.cuit == "123"
    }
}
