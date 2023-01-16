package com.kv.nosql.cosmos.mongo.api.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DataVerifier {

    //@Autowired
    //private UserRepository repository;

    @EventListener(ApplicationReadyEvent.class)
    public void onReady(ApplicationReadyEvent event) {
        log.info("Time taken to to application ready state - %s", event.getTimeTaken().getSeconds());
        //  Flux<UserDO> all = repository.findAll();
        //all.filter(o -> Objects.nonNull(o) && o.getAddress().getAddress1()!=null)
        //      .subscribe(o -> System.out.println(o.getId()));
    }
}