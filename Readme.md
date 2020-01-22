### Task List

- [x] Steps to reproduce provided
- [x] Stacktrace (if present) provided
- [x] Example that reproduces the problem uploaded to Github
- [x] Full description of the issue provided (see below)

### Steps to Reproduce
1. Clone the repo
2. Go to the root folder
3. `./gradlew build`
4. `docker-compose up --build api`
5. `curl -X POST -H "Content-Type: application/json" -d '{"cuit":"20123456789","gln": "1234356","name": "Acme"}' http://localhost:8080/laboratory`

### Expected Behaviour

Laboratory saved on the database and HttpResponse OK: 200

### Actual Behaviour

500 Internal Server Error
```
{
    "message": "Internal Server Error: Error encoding object [com.test.Laboratory : 1] to JSON: Could not obtain current Hibernate Session; nested exception is org.hibernate.HibernateException: No Session found for current thread (through reference chain: com.test.Laboratory[\"attached\"])"
}
```

*Stacktrace*
```
api_1      | 14:29:38.489 [pool-2-thread-2] ERROR i.m.h.s.netty.RoutingInBoundHandler - Unexpected error occurred: Error encoding object [com.test.Laboratory : 1] to JSON: Could not obtain current Hibernate Session; nested exception is org.hibernate.HibernateException: No Session found for current thread (through reference chain: com.test.Laboratory["attached"])
api_1      | io.micronaut.http.codec.CodecException: Error encoding object [com.test.Laboratory : 1] to JSON: Could not obtain current Hibernate Session; nested exception is org.hibernate.HibernateException: No Session found for current thread (through reference chain: com.test.Laboratory["attached"])
api_1      |    at io.micronaut.jackson.codec.JsonMediaTypeCodec.encode(JsonMediaTypeCodec.java:176)
api_1      |    at io.micronaut.jackson.codec.JsonMediaTypeCodec.encode(JsonMediaTypeCodec.java:182)
api_1      |    at io.micronaut.http.server.netty.RoutingInBoundHandler.encodeBodyAsByteBuf(RoutingInBoundHandler.java:1351)
api_1      |    at io.micronaut.http.server.netty.RoutingInBoundHandler.encodeBodyWithCodec(RoutingInBoundHandler.java:1297)
api_1      |    at io.micronaut.http.server.netty.RoutingInBoundHandler.lambda$subscribeToResponsePublisher$14(RoutingInBoundHandler.java:1232)
api_1      |    at io.micronaut.http.server.netty.RoutingInBoundHandler$$Lambda$619.00000000FC0D23A0.apply(Unknown Source)
api_1      |    at io.reactivex.internal.operators.flowable.FlowableMap$MapSubscriber.onNext(FlowableMap.java:63)
api_1      |    at io.micronaut.reactive.rxjava2.InstrumentedSubscriber.lambda$onNext$0(InstrumentedSubscriber.java:80)
api_1      |    at io.micronaut.reactive.rxjava2.InstrumentedSubscriber$$Lambda$637.00000000CDED5630.run(Unknown Source)
api_1      |    at io.micronaut.reactive.rxjava2.InstrumentedSubscriber.onNext(InstrumentedSubscriber.java:84)
api_1      |    at io.reactivex.internal.operators.flowable.FlowableSwitchMap$SwitchMapSubscriber.drain(FlowableSwitchMap.java:307)
api_1      |    at io.reactivex.internal.operators.flowable.FlowableSwitchMap$SwitchMapInnerSubscriber.onSubscribe(FlowableSwitchMap.java:366)
api_1      |    at io.micronaut.reactive.rxjava2.InstrumentedSubscriber.onSubscribe(InstrumentedSubscriber.java:75)
api_1      |    at io.reactivex.internal.operators.flowable.FlowableJust.subscribeActual(FlowableJust.java:34)
api_1      |    at io.reactivex.Flowable.subscribe(Flowable.java:14918)
api_1      |    at io.reactivex.Flowable.subscribe(Flowable.java:14865)
api_1      |    at io.micronaut.reactive.rxjava2.RxInstrumentedCallableFlowable.subscribeActual(RxInstrumentedCallableFlowable.java:65)
api_1      |    at io.reactivex.Flowable.subscribe(Flowable.java:14918)
api_1      |    at io.reactivex.Flowable.subscribe(Flowable.java:14865)
api_1      |    at io.reactivex.internal.operators.flowable.FlowableSwitchMap$SwitchMapSubscriber.onNext(FlowableSwitchMap.java:129)
api_1      |    at io.micronaut.reactive.rxjava2.InstrumentedSubscriber.lambda$onNext$0(InstrumentedSubscriber.java:80)
api_1      |    at io.micronaut.reactive.rxjava2.InstrumentedSubscriber$$Lambda$637.00000000CDED5630.run(Unknown Source)
api_1      |    at io.micronaut.reactive.rxjava2.InstrumentedSubscriber.onNext(InstrumentedSubscriber.java:84)
api_1      |    at io.reactivex.internal.operators.flowable.FlowableSubscribeOn$SubscribeOnSubscriber.onNext(FlowableSubscribeOn.java:97)
api_1      |    at io.micronaut.reactive.rxjava2.InstrumentedSubscriber.lambda$onNext$0(InstrumentedSubscriber.java:80)
api_1      |    at io.micronaut.reactive.rxjava2.InstrumentedSubscriber$$Lambda$637.00000000CDED5630.run(Unknown Source)
api_1      |    at io.micronaut.reactive.rxjava2.InstrumentedSubscriber.onNext(InstrumentedSubscriber.java:84)
api_1      |    at io.micronaut.http.context.ServerRequestTracingPublisher$1.lambda$onNext$1(ServerRequestTracingPublisher.java:60)
api_1      |    at io.micronaut.http.context.ServerRequestTracingPublisher$1$$Lambda$638.00000000CDED6510.run(Unknown Source)
api_1      |    at io.micronaut.http.context.ServerRequestContext.with(ServerRequestContext.java:52)
api_1      |    at io.micronaut.http.context.ServerRequestTracingPublisher$1.onNext(ServerRequestTracingPublisher.java:60)
api_1      |    at io.micronaut.http.context.ServerRequestTracingPublisher$1.onNext(ServerRequestTracingPublisher.java:52)
api_1      |    at io.reactivex.internal.util.HalfSerializer.onNext(HalfSerializer.java:45)
api_1      |    at io.reactivex.internal.subscribers.StrictSubscriber.onNext(StrictSubscriber.java:97)
api_1      |    at io.micronaut.reactive.rxjava2.InstrumentedSubscriber.lambda$onNext$0(InstrumentedSubscriber.java:80)
api_1      |    at io.micronaut.reactive.rxjava2.InstrumentedSubscriber$$Lambda$637.00000000CDED5630.run(Unknown Source)
api_1      |    at io.micronaut.reactive.rxjava2.InstrumentedSubscriber.onNext(InstrumentedSubscriber.java:84)
api_1      |    at io.reactivex.internal.operators.flowable.FlowableSwitchIfEmpty$SwitchIfEmptySubscriber.onNext(FlowableSwitchIfEmpty.java:59)
api_1      |    at io.micronaut.reactive.rxjava2.InstrumentedSubscriber.lambda$onNext$0(InstrumentedSubscriber.java:80)
api_1      |    at io.micronaut.reactive.rxjava2.InstrumentedSubscriber$$Lambda$637.00000000CDED5630.run(Unknown Source)
api_1      |    at io.micronaut.reactive.rxjava2.InstrumentedSubscriber.onNext(InstrumentedSubscriber.java:84)
api_1      |    at io.reactivex.internal.operators.flowable.FlowableMap$MapSubscriber.onNext(FlowableMap.java:68)
api_1      |    at io.micronaut.reactive.rxjava2.InstrumentedSubscriber.lambda$onNext$0(InstrumentedSubscriber.java:80)
api_1      |    at io.micronaut.reactive.rxjava2.InstrumentedSubscriber$$Lambda$637.00000000CDED5630.run(Unknown Source)
api_1      |    at io.micronaut.reactive.rxjava2.InstrumentedSubscriber.onNext(InstrumentedSubscriber.java:84)
api_1      |    at io.reactivex.internal.operators.flowable.FlowableCreate$NoOverflowBaseAsyncEmitter.onNext(FlowableCreate.java:403)
api_1      |    at io.micronaut.http.server.netty.RoutingInBoundHandler.lambda$buildResultEmitter$17(RoutingInBoundHandler.java:1422)
api_1      |    at io.micronaut.http.server.netty.RoutingInBoundHandler$$Lambda$607.00000000FC0A2190.subscribe(Unknown Source)
api_1      |    at io.reactivex.internal.operators.flowable.FlowableCreate.subscribeActual(FlowableCreate.java:71)
api_1      |    at io.reactivex.Flowable.subscribe(Flowable.java:14918)
api_1      |    at io.reactivex.Flowable.subscribe(Flowable.java:14865)
api_1      |    at io.micronaut.reactive.rxjava2.RxInstrumentedFlowable.subscribeActual(RxInstrumentedFlowable.java:68)
api_1      |    at io.reactivex.Flowable.subscribe(Flowable.java:14918)
api_1      |    at io.reactivex.internal.operators.flowable.FlowableMap.subscribeActual(FlowableMap.java:37)
api_1      |    at io.reactivex.Flowable.subscribe(Flowable.java:14918)
api_1      |    at io.reactivex.Flowable.subscribe(Flowable.java:14865)
api_1      |    at io.micronaut.reactive.rxjava2.RxInstrumentedFlowable.subscribeActual(RxInstrumentedFlowable.java:68)
api_1      |    at io.reactivex.Flowable.subscribe(Flowable.java:14918)
api_1      |    at io.reactivex.internal.operators.flowable.FlowableSwitchIfEmpty.subscribeActual(FlowableSwitchIfEmpty.java:32)
api_1      |    at io.reactivex.Flowable.subscribe(Flowable.java:14918)
api_1      |    at io.reactivex.Flowable.subscribe(Flowable.java:14865)
api_1      |    at io.micronaut.reactive.rxjava2.RxInstrumentedFlowable.subscribeActual(RxInstrumentedFlowable.java:68)
api_1      |    at io.reactivex.Flowable.subscribe(Flowable.java:14918)
api_1      |    at io.reactivex.Flowable.subscribe(Flowable.java:14868)
api_1      |    at io.micronaut.http.context.ServerRequestTracingPublisher.lambda$subscribe$0(ServerRequestTracingPublisher.java:52)
api_1      |    at io.micronaut.http.context.ServerRequestTracingPublisher$$Lambda$620.0000000000FEF200.run(Unknown Source)
api_1      |    at io.micronaut.http.context.ServerRequestContext.with(ServerRequestContext.java:52)
api_1      |    at io.micronaut.http.context.ServerRequestTracingPublisher.subscribe(ServerRequestTracingPublisher.java:52)
api_1      |    at io.reactivex.internal.operators.flowable.FlowableFromPublisher.subscribeActual(FlowableFromPublisher.java:29)
api_1      |    at io.reactivex.Flowable.subscribe(Flowable.java:14918)
api_1      |    at io.reactivex.Flowable.subscribe(Flowable.java:14865)
api_1      |    at io.micronaut.reactive.rxjava2.RxInstrumentedFlowable.subscribeActual(RxInstrumentedFlowable.java:68)
api_1      |    at io.reactivex.Flowable.subscribe(Flowable.java:14918)
api_1      |    at io.reactivex.Flowable.subscribe(Flowable.java:14865)
api_1      |    at io.reactivex.internal.operators.flowable.FlowableSubscribeOn$SubscribeOnSubscriber.run(FlowableSubscribeOn.java:82)
api_1      |    at io.reactivex.internal.schedulers.ExecutorScheduler$ExecutorWorker$BooleanRunnable.run(ExecutorScheduler.java:288)
api_1      |    at io.reactivex.internal.schedulers.ExecutorScheduler$ExecutorWorker.run(ExecutorScheduler.java:253)
api_1      |    at java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1128)
api_1      |    at java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:628)
api_1      |    at java.base/java.lang.Thread.run(Thread.java:825)
api_1      | Caused by: com.fasterxml.jackson.databind.JsonMappingException: Could not obtain current Hibernate Session; nested exception is org.hibernate.HibernateException: No Session found for current thread (through reference chain: com.test.Laboratory["attached"])
api_1      |    at com.fasterxml.jackson.databind.JsonMappingException.wrapWithPath(JsonMappingException.java:394)
api_1      |    at com.fasterxml.jackson.databind.JsonMappingException.wrapWithPath(JsonMappingException.java:353)
api_1      |    at com.fasterxml.jackson.databind.ser.std.StdSerializer.wrapAndThrow(StdSerializer.java:316)
api_1      |    at com.fasterxml.jackson.databind.ser.std.BeanSerializerBase.serializeFields(BeanSerializerBase.java:727)
api_1      |    at com.fasterxml.jackson.databind.ser.BeanSerializer.serialize(BeanSerializer.java:155)
api_1      |    at com.fasterxml.jackson.databind.ser.DefaultSerializerProvider._serialize(DefaultSerializerProvider.java:480)
api_1      |    at com.fasterxml.jackson.databind.ser.DefaultSerializerProvider.serializeValue(DefaultSerializerProvider.java:319)
api_1      |    at com.fasterxml.jackson.databind.ObjectMapper._configAndWriteValue(ObjectMapper.java:3906)
api_1      |    at com.fasterxml.jackson.databind.ObjectMapper.writeValueAsBytes(ObjectMapper.java:3244)
api_1      |    at io.micronaut.jackson.codec.JsonMediaTypeCodec.encode(JsonMediaTypeCodec.java:173)
api_1      |    ... 79 common frames omitted
api_1      | Caused by: org.springframework.dao.DataAccessResourceFailureException: Could not obtain current Hibernate Session; nested exception is org.hibernate.HibernateException: No Session found for current thread
api_1      |    at org.grails.orm.hibernate.GrailsHibernateTemplate.getSession(GrailsHibernateTemplate.java:335)
api_1      |    at org.grails.orm.hibernate.GrailsHibernateTemplate.doExecute(GrailsHibernateTemplate.java:284)
api_1      |    at org.grails.orm.hibernate.GrailsHibernateTemplate.contains(GrailsHibernateTemplate.java:405)
api_1      |    at org.grails.orm.hibernate.AbstractHibernateGormInstanceApi.isAttached(AbstractHibernateGormInstanceApi.groovy:220)
api_1      |    at org.grails.datastore.gorm.GormEntity$Trait$Helper.isAttached(GormEntity.groovy:176)
api_1      |    at org.grails.datastore.gorm.GormEntity$Trait$Helper$isAttached$0.call(Unknown Source)
api_1      |    at org.codehaus.groovy.runtime.callsite.CallSiteArray.defaultCall(CallSiteArray.java:47)
api_1      |    at org.codehaus.groovy.runtime.callsite.AbstractCallSite.call(AbstractCallSite.java:115)
api_1      |    at org.codehaus.groovy.runtime.callsite.AbstractCallSite.call(AbstractCallSite.java:127)
api_1      |    at com.test.Laboratory.isAttached(Laboratory.groovy)
api_1      |    at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
api_1      |    at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
api_1      |    at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
api_1      |    at java.base/java.lang.reflect.Method.invoke(Method.java:566)
api_1      |    at com.fasterxml.jackson.databind.ser.BeanPropertyWriter.serializeAsField(BeanPropertyWriter.java:688)
api_1      |    at com.fasterxml.jackson.databind.ser.std.BeanSerializerBase.serializeFields(BeanSerializerBase.java:719)
api_1      |    ... 85 common frames omitted
api_1      | Caused by: org.hibernate.HibernateException: No Session found for current thread
api_1      |    at org.grails.orm.hibernate.GrailsSessionContext.currentSession(GrailsSessionContext.java:112)
api_1      |    at org.hibernate.internal.SessionFactoryImpl.getCurrentSession(SessionFactoryImpl.java:495)
api_1      |    at org.grails.orm.hibernate.GrailsHibernateTemplate.getSession(GrailsHibernateTemplate.java:333)
api_1      |    ... 100 common frames omitted

```

### Environment Information

- **Operating System:** MacOS Catalina 10.15.2
- **Micronaut Version:** 1.2.9
- **JDK Version:** adoptopenjdk/openjdk11-openj9:jdk-11.0.1.13-alpine-slim

### Example Application

https://github.com/mpccolorado/micronaut-gorm-standalone

### Tests
**Another related issue**
The tests are passing and are not getting the exception in the same way as the actual application. Maybe I am doing something wrong but these are the tests:

```
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

```

