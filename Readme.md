Repository created in order to show a possible bug on micronaut with groovy: https://github.com/micronaut-projects/micronaut-groovy/issues/34#event-2970360074

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

### Note about Tests
In order to make the build success I have added an Ignore annotation on `LaboratoryControllerSpec`

*Stacktrace on test:*
```
io.micronaut.http.codec.CodecException: Error encoding object [com.test.Laboratory : (unsaved)] to JSON: Either class [com.test.Laboratory] is not a domain class or GORM has not been initialized correctly or has already been shutdown. Ensure GORM is loaded and configured correctly before calling any methods on a GORM entity. (through reference chain: com.test.Laboratory["attached"])
	at io.micronaut.jackson.codec.JsonMediaTypeCodec.encode(JsonMediaTypeCodec.java:176)
	at io.micronaut.jackson.codec.JsonMediaTypeCodec.encode(JsonMediaTypeCodec.java:182)
	at io.micronaut.http.client.DefaultHttpClient.lambda$buildNettyRequest$41(DefaultHttpClient.java:1556)
	at java.util.Optional.map(Optional.java:215)
	at io.micronaut.http.client.DefaultHttpClient.buildNettyRequest(DefaultHttpClient.java:1556)
	at io.micronaut.http.client.DefaultHttpClient.sendRequestThroughChannel(DefaultHttpClient.java:1594)
	at io.micronaut.http.client.DefaultHttpClient.lambda$null$27(DefaultHttpClient.java:1052)
	at io.netty.util.concurrent.DefaultPromise.notifyListener0(DefaultPromise.java:577)
	at io.netty.util.concurrent.DefaultPromise.notifyListeners0(DefaultPromise.java:570)
	at io.netty.util.concurrent.DefaultPromise.notifyListenersNow(DefaultPromise.java:549)
	at io.netty.util.concurrent.DefaultPromise.notifyListeners(DefaultPromise.java:490)
	at io.netty.util.concurrent.DefaultPromise.setValue0(DefaultPromise.java:615)
	at io.netty.util.concurrent.DefaultPromise.setSuccess0(DefaultPromise.java:604)
	at io.netty.util.concurrent.DefaultPromise.trySuccess(DefaultPromise.java:104)
	at io.netty.channel.DefaultChannelPromise.trySuccess(DefaultChannelPromise.java:84)
	at io.netty.channel.nio.AbstractNioChannel$AbstractNioUnsafe.fulfillConnectPromise(AbstractNioChannel.java:300)
	at io.netty.channel.nio.AbstractNioChannel$AbstractNioUnsafe.finishConnect(AbstractNioChannel.java:335)
	at io.netty.channel.nio.NioEventLoop.processSelectedKey(NioEventLoop.java:688)
	at io.netty.channel.nio.NioEventLoop.processSelectedKeysOptimized(NioEventLoop.java:635)
	at io.netty.channel.nio.NioEventLoop.processSelectedKeys(NioEventLoop.java:552)
	at io.netty.channel.nio.NioEventLoop.run(NioEventLoop.java:514)
	at io.netty.util.concurrent.SingleThreadEventExecutor$6.run(SingleThreadEventExecutor.java:1050)
	at io.netty.util.internal.ThreadExecutorMap$2.run(ThreadExecutorMap.java:74)
	at io.netty.util.concurrent.FastThreadLocalRunnable.run(FastThreadLocalRunnable.java:30)
	at java.lang.Thread.run(Thread.java:748)
Caused by: com.fasterxml.jackson.databind.JsonMappingException: Either class [com.test.Laboratory] is not a domain class or GORM has not been initialized correctly or has already been shutdown. Ensure GORM is loaded and configured correctly before calling any methods on a GORM entity. (through reference chain: com.test.Laboratory["attached"])
	at com.fasterxml.jackson.databind.JsonMappingException.wrapWithPath(JsonMappingException.java:394)
	at com.fasterxml.jackson.databind.JsonMappingException.wrapWithPath(JsonMappingException.java:353)
	at com.fasterxml.jackson.databind.ser.std.StdSerializer.wrapAndThrow(StdSerializer.java:316)
	at com.fasterxml.jackson.databind.ser.std.BeanSerializerBase.serializeFields(BeanSerializerBase.java:727)
	at com.fasterxml.jackson.databind.ser.BeanSerializer.serialize(BeanSerializer.java:155)
	at com.fasterxml.jackson.databind.ser.DefaultSerializerProvider._serialize(DefaultSerializerProvider.java:480)
	at com.fasterxml.jackson.databind.ser.DefaultSerializerProvider.serializeValue(DefaultSerializerProvider.java:319)
	at com.fasterxml.jackson.databind.ObjectMapper._configAndWriteValue(ObjectMapper.java:3906)
	at com.fasterxml.jackson.databind.ObjectMapper.writeValueAsBytes(ObjectMapper.java:3244)
	at io.micronaut.jackson.codec.JsonMediaTypeCodec.encode(JsonMediaTypeCodec.java:173)
	... 24 more
Caused by: java.lang.IllegalStateException: Either class [com.test.Laboratory] is not a domain class or GORM has not been initialized correctly or has already been shutdown. Ensure GORM is loaded and configured correctly before calling any methods on a GORM entity.
	at org.grails.datastore.gorm.GormEnhancer.stateException(GormEnhancer.groovy:467)
	at org.grails.datastore.gorm.GormEnhancer.findInstanceApi(GormEnhancer.groovy:315)
	at org.grails.datastore.gorm.GormEnhancer.findInstanceApi(GormEnhancer.groovy:312)
	at org.grails.datastore.gorm.GormEntity$Trait$Helper.currentGormInstanceApi(GormEntity.groovy:1366)
	at org.grails.datastore.gorm.GormEntity$Trait$Helper.isAttached(GormEntity.groovy:176)
	at com.fasterxml.jackson.databind.ser.BeanPropertyWriter.serializeAsField(BeanPropertyWriter.java:688)
	at com.fasterxml.jackson.databind.ser.std.BeanSerializerBase.serializeFields(BeanSerializerBase.java:719)
	... 30 more
```

