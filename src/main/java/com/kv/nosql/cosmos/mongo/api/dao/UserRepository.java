package com.kv.nosql.cosmos.mongo.api.dao;

import com.kv.nosql.cosmos.mongo.api.model.UserDO;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface UserRepository extends ReactiveCrudRepository<UserDO, String> {

    Flux<UserDO> findByFirstName(String name);
}
